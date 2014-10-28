
CREATE TEMPORARY TABLE domain_bootstrap(
  start_date domain_timestamp,
  user_id uuid,
  project_id uuid
);

CREATE FUNCTION pg_temp.bootstrap_domain()
RETURNS void
LANGUAGE plpgsql
AS $$
  DECLARE
    _start_date domain_timestamp;
    _user_id uuid;
    _project_id uuid;
  BEGIN

    _start_date := now();

    INSERT INTO users
      (username, name, created)
    VALUES
      ('system', 'System', _start_date)
    RETURNING user_id INTO _user_id;

    INSERT INTO projects
      (slug, name, creator_user_id, created)
    VALUES
      ('system', 'System', _user_id, _start_date)
    RETURNING project_id INTO _project_id;

    INSERT INTO project_roles
      (project_role_id, slug, project_mode)
    VALUES
      (101, 'owner', 200); -- 0310

    INSERT INTO project_user_grants
      (project_id, user_id, project_role_id, grantor_user_id, created)
    VALUES
      (_project_id, _user_id, 101, _user_id, _start_date); -- owner

    INSERT INTO domain_bootstrap
      (start_date, user_id, project_id)
    VALUES
      (_start_date, _user_id, _project_id);

  END;
$$;

CREATE FUNCTION pg_temp.define_domain_data()
RETURNS void
LANGUAGE plpgsql
AS $$
  DECLARE
    _domain domain_bootstrap;
  BEGIN

    PERFORM pg_temp.bootstrap_domain();

    SELECT * FROM domain_bootstrap
      INTO STRICT _domain;

    -- document_types

    INSERT INTO document_types
      (document_type_id, slug)
    VALUES
      (11, 'narrative');

    INSERT INTO document_types
      (document_type_id, slug)
    VALUES
      (21, 'perspective');

    INSERT INTO document_types
      (document_type_id, slug)
    VALUES
      (31, 'quotation');

    INSERT INTO document_types
      (document_type_id, slug)
    VALUES
      (41, 'collection');

    INSERT INTO document_types
      (document_type_id, slug)
    VALUES
      (51, 'documentation');

    -- link_target_types

    INSERT INTO link_target_types
      (link_target_type_id, slug)
    VALUES
      (11, 'void');

    INSERT INTO link_target_types
      (link_target_type_id, slug)
    VALUES
      (21, 'scalar');

    INSERT INTO link_target_types
      (link_target_type_id, slug)
    VALUES
      (31, 'entity');

    INSERT INTO link_target_types
      (link_target_type_id, slug)
    VALUES
      (41, 'document');

    INSERT INTO link_target_types
      (link_target_type_id, slug)
    VALUES
      (51, 'concept');

    INSERT INTO link_target_types
      (link_target_type_id, slug)
    VALUES
      (61, 'location');

    -- asset_types

    INSERT INTO asset_types
      (asset_type_id, value)
    VALUES
      (101, 'text/plain');

    INSERT INTO asset_types
      (asset_type_id, value)
    VALUES
      (102, 'text/vnd.fokus.markdown');

    INSERT INTO asset_types
      (asset_type_id, value)
    VALUES
      (111, 'image/gif');

    INSERT INTO asset_types
      (asset_type_id, value)
    VALUES
      (112, 'image/jpeg');

    INSERT INTO asset_types
      (asset_type_id, value)
    VALUES
      (113, 'image/png');

    INSERT INTO asset_types
      (asset_type_id, value)
    VALUES
      (114, 'image/svg+xml');

    INSERT INTO asset_types
      (asset_type_id, value)
    VALUES
      (115, 'image/tiff');

    INSERT INTO asset_types
      (asset_type_id, value)
    VALUES
      (121, 'application/citeproc+json');

    INSERT INTO asset_types
      (asset_type_id, value)
    VALUES
      (131, 'text/csv');

    -- asset_roles

    INSERT INTO asset_roles
      (asset_role_id, slug)
    VALUES
      (11, 'main');

    INSERT INTO asset_roles
      (asset_role_id, slug)
    VALUES
      (21, 'note');

    INSERT INTO asset_roles
      (asset_role_id, slug)
    VALUES
      (31, 'img');

    -- assessment_types

    INSERT INTO assessment_types
      (assessment_type_id, slug)
    VALUES
      (11, 'submit');

    INSERT INTO assessment_types
      (assessment_type_id, slug)
    VALUES
      (21, 'publish');

    -- project_roles

    -- owner role 101 inserted by bootstrap_domain()

    INSERT INTO project_roles
      (project_role_id, slug, project_mode)
    VALUES
      (102, 'administrator', 136); -- 0210

    INSERT INTO project_roles
      (project_role_id, slug, project_mode)
    VALUES
      (103, 'publisher', 31); -- 0037

    INSERT INTO project_roles
      (project_role_id, slug, project_mode)
    VALUES
      (104, 'editor', 28); -- 0017

    INSERT INTO project_roles
      (project_role_id, slug, project_mode)
    VALUES
      (105, 'writer', 14); -- 0016

    INSERT INTO project_roles
      (project_role_id, slug, project_mode)
    VALUES
      (106, 'reader', 12); -- 0014

    -- release_tags

    INSERT INTO release_tags
      (release_tag_id, slug)
    VALUES
      (11, 'submitted');

    INSERT INTO release_tags
      (release_tag_id, slug)
    VALUES
      (21, 'published');

    -- domain link_types

    INSERT INTO link_types
      (link_type_id, project_id, slug, link_target_type_id, creator_user_id, created)
    VALUES
      (1, _domain.project_id, 'has-prototype', 51, _domain.user_id, _domain.start_date);

    CREATE UNIQUE INDEX uniq_rev_links_revision_prototype
      ON revision_links ( revision_id )
      WHERE link_type_id = 1;

    INSERT INTO link_types
      (link_type_id, project_id, slug, link_target_type_id, creator_user_id, created)
    VALUES
      (11, _domain.project_id, 'defines', 31, _domain.user_id, _domain.start_date);

    CREATE UNIQUE INDEX uniq_rev_links_revision_defines
      ON revision_links ( revision_id )
      WHERE link_type_id = 11;

    INSERT INTO link_types
      (link_type_id, project_id, slug, link_target_type_id, creator_user_id, created)
    VALUES
      (21, _domain.project_id, 'aliased-by', 11, _domain.user_id, _domain.start_date);

    INSERT INTO link_types
      (link_type_id, project_id, slug, link_target_type_id, creator_user_id, created)
    VALUES
      (31, _domain.project_id, 'related-to-concept', 51, _domain.user_id, _domain.start_date);

    INSERT INTO link_types
      (link_type_id, converse_link_type_id, project_id, slug, link_target_type_id, creator_user_id, created)
    VALUES
      (41, 42, _domain.project_id, 'has-collection-member', 41, _domain.user_id, _domain.start_date),
      (42, 41, _domain.project_id, 'member-of-collection',  41, _domain.user_id, _domain.start_date);

    INSERT INTO link_types
      (link_type_id, project_id, slug, link_target_type_id, creator_user_id, created)
    VALUES
      (51, _domain.project_id, 'has-locus', 61, _domain.user_id, _domain.start_date);

    -- concept_relation_types

    INSERT INTO concept_relation_types
      (concept_relation_type_id, slug, project_id, creator_user_id, created)
    VALUES
      (101, 'has-broader', _domain.project_id, _domain.user_id, _domain.start_date);

  END;
$$;

SELECT pg_temp.define_domain_data();

CREATE FUNCTION recursively_narrowed_concepts(top_concept_id uuid)
RETURNS TABLE(concept_id uuid,
              parent_concept_id uuid,
              project_id uuid,
              name domain_string_255_nonblank,
              short_name domain_string_255_nonblank,
              slug domain_slug_long)
LANGUAGE plpgsql
AS $$
  BEGIN
    RETURN QUERY
    WITH RECURSIVE concept_descent_summary AS (

      SELECT c.concept_id, NULL::uuid, c.project_id, c.name, c.short_name, c.slug
      FROM concepts c
      WHERE c.concept_id = top_concept_id

      UNION -- a node may descend multiple times from an ancestor

      SELECT c.concept_id, d.concept_id, c.project_id, c.name, c.short_name, c.slug
      FROM concept_descent_summary d
      JOIN concept_relations cr
        ON cr.related_concept_id = d.concept_id
      JOIN concepts c
        ON c.concept_id = cr.concept_id
      WHERE cr.concept_relation_type_id = 101 -- broader

    )
    SELECT * FROM concept_descent_summary;
  END;
$$;

CREATE FUNCTION recursively_broadened_concepts(top_concept_id uuid)
RETURNS TABLE(concept_id uuid,
              parent_concept_id uuid,
              project_id uuid,
              name domain_string_255_nonblank,
              short_name domain_string_255_nonblank,
              slug domain_slug_long)
LANGUAGE plpgsql
AS $$
  BEGIN
    RETURN QUERY
    WITH RECURSIVE concept_ascent_summary AS (

      SELECT c.concept_id, NULL::uuid, c.project_id, c.name, c.short_name, c.slug
      FROM concepts c
      WHERE c.concept_id = top_concept_id

      UNION -- a node may descend multiple times from an ancestor

      SELECT c.concept_id, d.concept_id, c.project_id, c.name, c.short_name, c.slug
      FROM concept_ascent_summary d
      JOIN concept_relations cr
        ON cr.concept_id = d.concept_id
      JOIN concepts c
        ON c.concept_id = cr.related_concept_id
      WHERE cr.concept_relation_type_id = 101 -- broader

    )
    SELECT * FROM concept_ascent_summary;
  END;
$$;

