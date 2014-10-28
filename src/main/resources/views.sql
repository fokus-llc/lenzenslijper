
---- TYPES

CREATE TYPE revision_summary
  AS (
    revision_id uuid,
    document_id uuid,
    created domain_timestamp,
    user_id uuid,
    document_type_id domain_positive_integer,
    project_id uuid
  );

---- MATERIALIZED VIEWS (*_summaries)

CREATE TABLE released_title_summaries(

  release_tag_id domain_positive_integer NOT NULL,
  document_id uuid NOT NULL,
  title domain_string_255_nonblank NOT NULL,

  CONSTRAINT uniq_rel_titles_tag_document
    PRIMARY KEY ( release_tag_id, document_id, title ),

  CONSTRAINT for_rel_titles_tag
    FOREIGN KEY ( release_tag_id )
    REFERENCES release_tags ( release_tag_id ),
  CONSTRAINT for_rel_titles_document
    FOREIGN KEY ( document_id )
    REFERENCES documents ( document_id )

);

CREATE INDEX key_rel_titles_tag_title
  ON released_title_summaries ( release_tag_id, title );

--

-- revisions per release
CREATE TABLE released_revision_summaries(

  revision_id uuid NOT NULL,
  release_tag_id domain_positive_integer NOT NULL,
  document_id uuid NOT NULL,
  created domain_timestamp NOT NULL,
  assessed domain_timestamp NOT NULL,

  CONSTRAINT uniq_rel_summaries_revision_tag
    PRIMARY KEY ( revision_id, release_tag_id ),

  CONSTRAINT for_rel_summaries_revision
    FOREIGN KEY (revision_id)
    REFERENCES revisions (revision_id),
  CONSTRAINT for_rel_summaries_tag
    FOREIGN KEY (release_tag_id)
    REFERENCES release_tags (release_tag_id),
  CONSTRAINT for_rel_summaries_document
    FOREIGN KEY (document_id)
    REFERENCES documents (document_id)

);

CREATE INDEX key_rel_summaries_document_tag_created
  ON released_revision_summaries ( document_id, release_tag_id, created );

--

CREATE TABLE submitted_definition_summaries(

  revision_id uuid NOT NULL,
  user_id uuid,                                         -- denormed (revisions)
  document_id uuid NOT NULL,                         --

  document_type_id domain_positive_integer NOT NULL, -- denormed (documents)
  prototype_concept_id uuid,                            --
  project_id uuid NOT NULL,                             --

  title domain_string_255_nonblank NOT NULL,            -- denormed (revision_links:defines)
  entity_id uuid,                                       --

  assessed domain_timestamp NOT NULL,

  CONSTRAINT uniq_sub_document_document
    PRIMARY KEY ( document_id ),
  CONSTRAINT uniq_sub_document_revision
    UNIQUE ( revision_id ),

  CONSTRAINT for_sub_document_revision
    FOREIGN KEY ( revision_id )
    REFERENCES revisions ( revision_id ),
  CONSTRAINT for_sub_document_user
    FOREIGN KEY ( user_id )
    REFERENCES users ( user_id ),
  CONSTRAINT for_sub_document_document
    FOREIGN KEY ( document_id )
    REFERENCES documents ( document_id ),
  CONSTRAINT for_sub_document_document_type
    FOREIGN KEY ( document_type_id )
    REFERENCES document_types ( document_type_id ),
  CONSTRAINT for_sub_document_document_prototype
    FOREIGN KEY ( prototype_concept_id )
    REFERENCES concepts ( concept_id ),
  CONSTRAINT for_sub_document_project
    FOREIGN KEY ( project_id )
    REFERENCES projects ( project_id ),
  CONSTRAINT for_sub_document_entity
    FOREIGN KEY ( entity_id )
    REFERENCES entities ( entity_id )

);

CREATE INDEX key_sub_document_type_prototype_title
  ON submitted_definition_summaries ( document_type_id, prototype_concept_id, title );

CREATE INDEX key_sub_document_type_prototype_assessed
  ON submitted_definition_summaries ( document_type_id, prototype_concept_id, assessed );

CREATE INDEX key_sub_document_type_title
  ON submitted_definition_summaries ( document_type_id, title );

CREATE INDEX key_sub_document_type_assessed
  ON submitted_definition_summaries ( document_type_id, assessed );

CREATE INDEX key_sub_document_project_type_prototype_title
  ON submitted_definition_summaries ( project_id, document_type_id, prototype_concept_id, title );

CREATE INDEX key_sub_document_project_type_prototype_assessed
  ON submitted_definition_summaries ( project_id, document_type_id, prototype_concept_id, assessed );

CREATE INDEX key_sub_document_project_type_title
  ON submitted_definition_summaries ( project_id, document_type_id, title );

CREATE INDEX key_sub_document_project_type_assessed
  ON submitted_definition_summaries ( project_id, document_type_id, assessed );

CREATE INDEX key_sub_document_project_title_assessed
  ON submitted_definition_summaries ( project_id, title, assessed );

CREATE INDEX key_sub_document_project_prototype_title
  ON submitted_definition_summaries ( project_id, prototype_concept_id, title );

CREATE INDEX key_sub_document_project_prototype_assessed
  ON submitted_definition_summaries ( project_id, prototype_concept_id, assessed );

CREATE INDEX key_sub_document_project_assessed
  ON submitted_definition_summaries ( project_id, assessed );

CREATE INDEX key_sub_document_title_assessed
  ON submitted_definition_summaries ( title, assessed );

CREATE INDEX key_sub_document_entity_title
  ON submitted_definition_summaries ( entity_id, title );

CREATE INDEX key_sub_document_entity_assessed
  ON submitted_definition_summaries ( entity_id, assessed );

CREATE INDEX key_sub_document_prototype_title
  ON submitted_definition_summaries ( prototype_concept_id, title );

CREATE INDEX key_sub_document_prototype_assessed
  ON submitted_definition_summaries ( prototype_concept_id, assessed );

CREATE INDEX key_sub_document_assessed
  ON submitted_definition_summaries ( assessed );

--

CREATE TABLE submitted_link_summaries(

  revision_id uuid NOT NULL,

  document_id uuid NOT NULL,                     -- denormed (revisions)

  link_type_id domain_positive_integer NOT NULL,    -- denormed (revision_links)
  target_title domain_string_255_nonblank NOT NULL,
  target_linkable_id uuid,
  target_value domain_string_255_nonblank,
  rank domain_natural_integer,
  time_range domain_string_255_nonblank,
  beginning bigint,
  ending bigint,

  CONSTRAINT uniq_sub_links_revision_type_ttitle
    PRIMARY KEY ( revision_id, link_type_id, target_title ),

  CONSTRAINT for_sub_links_revision
    FOREIGN KEY ( revision_id )
    REFERENCES revisions ( revision_id ),
  CONSTRAINT for_sub_links_document
    FOREIGN KEY ( document_id )
    REFERENCES documents ( document_id ),
  CONSTRAINT for_sub_links_type
    FOREIGN KEY ( link_type_id )
    REFERENCES link_types ( link_type_id ),
  CONSTRAINT for_sub_links_linkable
    FOREIGN KEY ( target_linkable_id )
    REFERENCES linkables ( linkable_id ),

  CONSTRAINT check_sub_links_single_target
    CHECK ((CASE WHEN target_linkable_id IS NOT NULL THEN 1 ELSE 0 END +
            CASE WHEN target_value       IS NOT NULL THEN 1 ELSE 0 END ) < 2)

);

CREATE INDEX key_sub_links_document_type_rank
  ON submitted_link_summaries ( document_id, link_type_id, rank );

CREATE INDEX key_sub_links_linkable_type
  ON submitted_link_summaries ( target_linkable_id, link_type_id );

CREATE INDEX key_sub_links_linkable_beginning
  ON submitted_link_summaries ( target_linkable_id, beginning );

CREATE INDEX key_sub_links_beginning
  ON submitted_link_summaries ( beginning );

--

CREATE TABLE published_definition_summaries(

  revision_id uuid NOT NULL,
  user_id uuid,                                         -- denormed (revisions)
  document_id uuid NOT NULL,                            --

  document_type_id domain_positive_integer NOT NULL,    -- denormed (documents)
  prototype_concept_id uuid,                            --
  project_id uuid NOT NULL,                             --

  title domain_string_255_nonblank NOT NULL,            -- denormed (revision_links:defines)
  entity_id uuid,                                       --

  assessed domain_timestamp NOT NULL,

  CONSTRAINT uniq_pub_document_document
    PRIMARY KEY ( document_id ),
  CONSTRAINT uniq_pub_document_revision
    UNIQUE ( revision_id ),

  CONSTRAINT for_pub_document_revision
    FOREIGN KEY ( revision_id )
    REFERENCES revisions ( revision_id ),
  CONSTRAINT for_pub_document_user
    FOREIGN KEY ( user_id )
    REFERENCES users ( user_id ),
  CONSTRAINT for_pub_document_document
    FOREIGN KEY ( document_id )
    REFERENCES documents ( document_id ),
  CONSTRAINT for_pub_document_document_type
    FOREIGN KEY ( document_type_id )
    REFERENCES document_types ( document_type_id ),
  CONSTRAINT for_pub_document_document_prototype
    FOREIGN KEY ( prototype_concept_id )
    REFERENCES concepts ( concept_id ),
  CONSTRAINT for_pub_document_project
    FOREIGN KEY ( project_id )
    REFERENCES projects ( project_id ),
  CONSTRAINT for_pub_document_entity
    FOREIGN KEY ( entity_id )
    REFERENCES entities ( entity_id )

);

CREATE INDEX key_pub_document_type_prototype_title
  ON published_definition_summaries ( document_type_id, prototype_concept_id, title );

CREATE INDEX key_pub_document_type_prototype_assessed
  ON published_definition_summaries ( document_type_id, prototype_concept_id, assessed );

CREATE INDEX key_pub_document_type_title
  ON published_definition_summaries ( document_type_id, title );

CREATE INDEX key_pub_document_type_assessed
  ON published_definition_summaries ( document_type_id, assessed );

CREATE INDEX key_pub_document_project_type_prototype_title
  ON published_definition_summaries ( project_id, document_type_id, prototype_concept_id, title );

CREATE INDEX key_pub_document_project_type_prototype_assessed
  ON published_definition_summaries ( project_id, document_type_id, prototype_concept_id, assessed );

CREATE INDEX key_pub_document_project_type_title
  ON published_definition_summaries ( project_id, document_type_id, title );

CREATE INDEX key_pub_document_project_type_assessed
  ON published_definition_summaries ( project_id, document_type_id, assessed );

CREATE INDEX key_pub_document_project_title_assessed
  ON published_definition_summaries ( project_id, title, assessed );

CREATE INDEX key_pub_document_project_prototype_title
  ON published_definition_summaries ( project_id, prototype_concept_id, title );

CREATE INDEX key_pub_document_project_prototype_assessed
  ON published_definition_summaries ( project_id, prototype_concept_id, assessed );

CREATE INDEX key_pub_document_project_assessed
  ON published_definition_summaries ( project_id, assessed );

CREATE INDEX key_pub_document_title_assessed
  ON published_definition_summaries ( title, assessed );

CREATE INDEX key_pub_document_entity_title
  ON published_definition_summaries ( entity_id, title );

CREATE INDEX key_pub_document_entity_assessed
  ON published_definition_summaries ( entity_id, assessed );

CREATE INDEX key_pub_document_prototype_title
  ON published_definition_summaries ( prototype_concept_id, title );

CREATE INDEX key_pub_document_prototype_assessed
  ON published_definition_summaries ( prototype_concept_id, assessed );

CREATE INDEX key_pub_document_assessed
  ON published_definition_summaries ( assessed );

--

-- indexed by document/entity origin and target
CREATE TABLE published_link_summaries(

  revision_id uuid NOT NULL,
  document_id uuid NOT NULL,                        -- denormed (revisions)
  link_type_id domain_positive_integer NOT NULL,    -- denormed (revision_links)
  target_title domain_string_255_nonblank NOT NULL,

  target_linkable_id uuid,

  time_range domain_string_255_nonblank,
  target_value domain_string_255_nonblank,
  rank domain_natural_integer,

  beginning bigint,
  ending bigint,

  CONSTRAINT uniq_plinks_revision_ltype_ttitle
    PRIMARY KEY ( revision_id, link_type_id, target_title ),

  CONSTRAINT for_plinks_revision
    FOREIGN KEY (revision_id)
    REFERENCES revisions (revision_id),
  CONSTRAINT for_plinks_document
    FOREIGN KEY (document_id)
    REFERENCES documents (document_id),
  CONSTRAINT for_plinks_type
    FOREIGN KEY (link_type_id)
    REFERENCES link_types (link_type_id),
  CONSTRAINT for_plinks_linkable
    FOREIGN KEY (target_linkable_id)
    REFERENCES linkables (linkable_id),

  CONSTRAINT check_plinks_single_target
    CHECK ((CASE WHEN target_linkable_id IS NOT NULL THEN 1 ELSE 0 END +
            CASE WHEN target_value       IS NOT NULL THEN 1 ELSE 0 END ) < 2)

);

CREATE INDEX key_plinks_document_ltype_rank
  ON published_link_summaries ( document_id, link_type_id, rank );

CREATE INDEX key_plinks_linkable_ltype
  ON published_link_summaries ( target_linkable_id, link_type_id );

CREATE INDEX key_plinks_linkable_beginning
  ON published_link_summaries ( target_linkable_id, beginning );

CREATE INDEX key_plinks_beginning
  ON published_link_summaries ( beginning );

--

CREATE FUNCTION process_definition_for_submission(_title domain_string_255_nonblank,
                                                  _revision_summary revision_summary,
                                                  _prototype_concept_id uuid,
                                                  _entity_id uuid)
RETURNS VOID
LANGUAGE plpgsql
AS $$
  BEGIN

    INSERT INTO submitted_definition_summaries
      (
        revision_id, user_id, document_id,
        document_type_id, prototype_concept_id, project_id,
        title, entity_id,
        assessed
      )
    VALUES
      (
        _revision_summary.revision_id, _revision_summary.user_id, _revision_summary.document_id,
        _revision_summary.document_type_id, _prototype_concept_id, _revision_summary.project_id,
        _title, _entity_id,
        _revision_summary.created
      );

  END;
$$;

--

CREATE FUNCTION process_definition_for_publication(_title domain_string_255_nonblank,
                                                   _revision_summary revision_summary,
                                                   _prototype_concept_id uuid,
                                                   _entity_id uuid)
RETURNS VOID
LANGUAGE plpgsql
AS $$
  BEGIN

    INSERT INTO published_definition_summaries
      (
        revision_id, user_id, document_id,
        document_type_id, prototype_concept_id, project_id,
        title, entity_id,
        assessed
      )
    VALUES
      (
        _revision_summary.revision_id, _revision_summary.user_id, _revision_summary.document_id,
        _revision_summary.document_type_id, _prototype_concept_id, _revision_summary.project_id,
        _title, _entity_id,
        _revision_summary.created
      );

  END;
$$;

--

CREATE FUNCTION process_link_for_submission(_revision_link revision_links,
                                            _revision_summary revision_summary)
RETURNS VOID
LANGUAGE plpgsql
AS $$
  BEGIN

    INSERT INTO submitted_link_summaries
      (
        revision_id,
        document_id,
        link_type_id, target_title,
        target_linkable_id, target_value,
        rank,
        beginning, ending
      )
    VALUES
      (
        _revision_summary.revision_id,
        _revision_summary.document_id,
        _revision_link.link_type_id, _revision_link.target_title,
        _revision_link.target_linkable_id, _revision_link.target_value,
        _revision_link.rank,
        _revision_link.beginning, _revision_link.ending
      );

  END;
$$;

--

CREATE FUNCTION process_link_for_publication(_revision_link revision_links,
                                             _revision_summary revision_summary)
RETURNS VOID
LANGUAGE plpgsql
AS $$
  BEGIN

    INSERT INTO published_link_summaries
      (
        revision_id,
        document_id,
        link_type_id, target_title,
        target_linkable_id, target_value,
        rank,
        beginning, ending
      )
    VALUES
      (
        _revision_summary.revision_id,
        _revision_summary.document_id,
        _revision_link.link_type_id, _revision_link.target_title,
        _revision_link.target_linkable_id, _revision_link.target_value,
        _revision_link.rank,
        _revision_link.beginning, _revision_link.ending
      );

  END;
$$;

--

CREATE FUNCTION process_document_pre_release(_release_tag_id domain_positive_integer, _document_id uuid)
RETURNS VOID
LANGUAGE plpgsql
AS $$
  BEGIN

    DELETE
      FROM released_title_summaries
      WHERE release_tag_id = _release_tag_id
        AND document_id = _document_id;

    IF _release_tag_id = 11 THEN -- RELEASE_TAG_SUBMITTED

      DELETE
        FROM submitted_definition_summaries
        WHERE document_id = _document_id;

      DELETE
        FROM submitted_link_summaries
        WHERE document_id = _document_id;

    ELSIF _release_tag_id = 21 THEN -- RELEASE_TAG_PUBLISHED

      DELETE
        FROM published_definition_summaries
        WHERE document_id = _document_id;

      DELETE
        FROM published_link_summaries
        WHERE document_id = _document_id;

    END IF;

  END;
$$;

--

CREATE FUNCTION process_released_title(_release_tag_id domain_positive_integer,
                                       _document_id uuid,
                                       _title domain_string_255_nonblank)
RETURNS VOID
LANGUAGE plpgsql
AS $$
  BEGIN

    INSERT INTO released_title_summaries
      (
        release_tag_id,
        document_id,
        title
      )
    VALUES
      (
        _release_tag_id,
        _document_id,
        _title
      );

  END;
$$;

--

CREATE FUNCTION process_released_definition(_release_tag_id domain_positive_integer,
                                            _revision_link revision_links,
                                            _revision_summary revision_summary,
                                            _prototype_concept_id uuid,
                                            _entity_id uuid)
RETURNS VOID
LANGUAGE plpgsql
AS $$
  BEGIN

    PERFORM process_released_title(_release_tag_id,
                                   _revision_summary.document_id,
                                   _revision_link.target_title);

    IF _release_tag_id = 11 THEN -- RELEASE_TAG_SUBMITTED

      PERFORM process_definition_for_submission(_revision_link.target_title,
                                                _revision_summary,
                                                _prototype_concept_id,
                                                _entity_id);

    ELSIF _release_tag_id = 21 THEN -- RELEASE_TAG_PUBLISHED

      PERFORM process_definition_for_publication(_revision_link.target_title,
                                                 _revision_summary,
                                                _prototype_concept_id,
                                                 _entity_id);

    END IF;

  END;
$$;

--

CREATE FUNCTION process_revision_for_release(_release_tag_id domain_positive_integer,
                                             _revision_summary revision_summary)
RETURNS VOID
LANGUAGE plpgsql
AS $$
  DECLARE
    _revision_link revision_links;
    _prototype_concept_id uuid;
    _entity_id uuid;
  BEGIN

    FOR _revision_link IN
    SELECT *
      FROM revision_links
      WHERE revision_id = _revision_summary.revision_id
      ORDER BY link_type_id -- prototype first
    LOOP

      IF _revision_link.link_type_id = 1 THEN -- LINK_TYPE_HAS_PROTOTYPE

        IF _revision_link.target_linkable_id IS NOT NULL THEN
          SELECT concept_id
            INTO STRICT _prototype_concept_id
            FROM linkables
            WHERE linkable_id = _revision_link.target_linkable_id;
        END IF;

      ELSIF _revision_link.link_type_id = 11 THEN -- LINK_TYPE_DEFINES

        -- target of entity this link represents subject of other links
        IF _revision_link.target_linkable_id IS NOT NULL THEN
          SELECT entity_id
            INTO STRICT _entity_id
            FROM linkables
            WHERE linkable_id = _revision_link.target_linkable_id;
        END IF;

        PERFORM process_released_definition(_release_tag_id,
                                            _revision_link,
                                            _revision_summary,
                                            _prototype_concept_id, _entity_id);

      ELSIF _revision_link.link_type_id = 21 THEN -- LINK_TYPE_ALIASED_BY

        PERFORM process_released_title(_release_tag_id,
                                       _revision_summary.document_id,
                                       _revision_link.target_title);

      END IF;

      IF _release_tag_id = 11 THEN -- RELEASE_TAG_SUBMITTED

        PERFORM process_link_for_submission(_revision_link, _revision_summary);

      ELSIF _release_tag_id = 21 THEN -- RELEASE_TAG_PUBLISHED

        PERFORM process_link_for_publication(_revision_link, _revision_summary);

      END IF;

    END LOOP;

  END;
$$;

--

CREATE FUNCTION process_assessment_for_tagged_release(_release_tag_id domain_positive_integer,
                                                      _revision_assessment revision_assessments)
RETURNS VOID
LANGUAGE plpgsql
AS $$
  DECLARE
    _revision_summary revision_summary;
    _latest_release released_revision_summaries;
  BEGIN

    SELECT r.revision_id, r.document_id, r.created, r.user_id,
        p.document_type_id, p.project_id
      INTO STRICT _revision_summary
      FROM revisions r
      JOIN documents p
        ON p.document_id = r.document_id
      WHERE r.revision_id = _revision_assessment.revision_id;

    SELECT *
      INTO _latest_release
      FROM released_revision_summaries
      WHERE document_id = _revision_summary.document_id
        AND release_tag_id = _release_tag_id
      ORDER BY created DESC
      LIMIT 1;

    IF (_latest_release IS NULL) OR (_revision_summary.revision_id <> _latest_release.revision_id) THEN

      INSERT INTO released_revision_summaries
        (
          revision_id,
          release_tag_id,
          document_id,
          created,
          assessed
        )
      VALUES
        (
          _revision_summary.revision_id,
          _release_tag_id,
          _revision_summary.document_id,
          _revision_summary.created,
          _revision_assessment.created
        );

      IF (_release_tag_id = 11 OR _release_tag_id = 21) AND -- RELEASE_TAG_SUBMITTED, RELEASE_TAG_PUBLISHED
         (_latest_release.created IS NULL OR _latest_release.created < _revision_summary.created) THEN

        PERFORM process_document_pre_release(_release_tag_id, _revision_summary.document_id);
        PERFORM process_revision_for_release(_release_tag_id, _revision_summary);

      END IF;

    END IF;

  END;
$$;

--

CREATE FUNCTION process_inserted_assessment()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
  BEGIN

    IF NEW.assessment_type_id = 11 THEN -- ASSESSMENT_TYPE_SUBMITTED
      PERFORM process_assessment_for_tagged_release(11, NEW); -- RELEASE_TAG_SUBMITTED
    ELSIF NEW.assessment_type_id = 21 THEN -- ASSESSMENT_TYPE_PUBLISHED
      PERFORM process_assessment_for_tagged_release(21, NEW); -- RELEASE_TAG_PUBLISHED
    END IF;
    RETURN NEW;

  END;
$$;

CREATE TRIGGER on_rassessments_insert_summarize
  AFTER INSERT ON revision_assessments
  FOR EACH ROW
  EXECUTE PROCEDURE process_inserted_assessment();

---- VIEWS

CREATE VIEW virtual_aggregate_grants AS
  SELECT pug.user_id, pug.project_id, bit_or(pr.project_mode) AS mode
  FROM project_user_grants pug
  JOIN project_roles pr
    ON pr.project_role_id = pug.project_role_id
  GROUP BY pug.project_id, pug.user_id;

CREATE VIEW virtual_api_users AS
  SELECT u.username AS user_name, u.api_token AS auth_token
  FROM users u
  WHERE u.api_token IS NOT NULL;

CREATE VIEW virtual_api_roles AS
  SELECT u.username, p.slug AS role_name
  FROM users u
  JOIN project_user_grants pug
    ON pug.user_id = u.user_id
  JOIN projects p
    ON p.project_id = pug.project_id
  WHERE u.api_token IS NOT NULL;

