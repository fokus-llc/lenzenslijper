
---- EXTENSIONS

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
COMMENT ON EXTENSION plpgsql
  IS 'PL/pgSQL procedural language';

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;
COMMENT ON EXTENSION "uuid-ossp"
  IS 'generate universally unique identifiers (UUIDs)';

CREATE EXTENSION IF NOT EXISTS "postgis" WITH SCHEMA public;
COMMENT ON EXTENSION "uuid-ossp"
  IS 'robust spatial database management capabilities';

---- DOMAINS

CREATE DOMAIN domain_slug
  AS text
  CONSTRAINT check_slug
  CHECK( VALUE ~ '^[a-z0-9][a-z0-9-]{0,62}[a-z0-9]$' );

CREATE DOMAIN domain_slug_long
  AS text
  CONSTRAINT check_slug
  CHECK( VALUE ~ '^[a-z0-9][a-z0-9-]{0,253}[a-z0-9]$' );

CREATE DOMAIN domain_string_255_nonblank
  AS text
  CONSTRAINT check_domain_string_255_nonblank_length
  CHECK( LENGTH(VALUE) BETWEEN 1 AND 255 );

CREATE DOMAIN domain_string_32_nonblank
  AS text
  CONSTRAINT check_domain_string_32_nonblank_length
  CHECK( LENGTH(VALUE) BETWEEN 1 AND 32 );

CREATE DOMAIN domain_timestamp
  AS timestamp with time zone;

CREATE DOMAIN domain_positive_integer
  AS integer
  CONSTRAINT check_domain_positive_integer
    CHECK( VALUE >= 0 );

CREATE DOMAIN domain_natural_integer
  AS integer
  CONSTRAINT check_domain_natural_integer
    CHECK( VALUE > 0 );

CREATE DOMAIN domain_status
  AS char
  DEFAULT 'A'
  NOT NULL
  CONSTRAINT check_domain_status
    CHECK( VALUE IN ('A', 'D', 'X') );

-- blankable domains for legacy columns

CREATE DOMAIN domain_string_255_blankable
  AS text
  CONSTRAINT check_domain_string_255_length
  CHECK( LENGTH(VALUE) < 256 );

CREATE DOMAIN domain_string_60_blankable
  AS text
  CONSTRAINT check_domain_string_60_length
  CHECK( LENGTH(VALUE) < 61 );

---- FUNCTIONS

CREATE FUNCTION process_row_updated_timestamp()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
  BEGIN

    NEW.row_updated = now();
    RETURN NEW;

  END;
$$;

---- USER TABLE

CREATE TABLE users(

  user_id uuid DEFAULT uuid_generate_v4() NOT NULL,

  username domain_string_255_nonblank NOT NULL,

  encrypted_password domain_string_255_blankable,   -- devise

  reset_password_token domain_string_255_blankable, -- devise
  reset_password_sent_at domain_timestamp,          -- devise

  remember_created_at domain_timestamp,             -- devise
  remember_token domain_string_255_blankable,       -- devise

  sign_in_count domain_positive_integer DEFAULT 0,  -- devise
  current_sign_in_at domain_timestamp,              -- devise
  current_sign_in_ip domain_string_255_blankable,   -- devise
  last_sign_in_at domain_timestamp,                 -- devise
  last_sign_in_ip domain_string_255_blankable,      -- devise

  confirmation_token domain_string_255_blankable,   -- devise
  confirmation_sent_at domain_timestamp,            -- devise
  confirmed_at domain_timestamp,                    -- devise
  unconfirmed_email domain_string_255_blankable,    -- devise,

  invitation_token domain_string_60_blankable,      -- devise
  invitation_sent_at domain_timestamp,              -- devise
  invitation_accepted_at domain_timestamp,          -- devise
  invited_by_id uuid,                               -- devise
  invited_by_type domain_string_255_blankable,      -- devise
  invitation_limit domain_positive_integer,         -- devise

  api_token domain_string_255_blankable,

  name domain_string_255_nonblank,
  email domain_string_255_blankable,                -- devise

  status domain_status,

  created domain_timestamp NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_users_id
    PRIMARY KEY ( user_id ),
  CONSTRAINT uniq_users_invitation_token
    UNIQUE ( invitation_token ),
  CONSTRAINT uniq_users_reset_token
    UNIQUE ( reset_password_token )

);

CREATE UNIQUE INDEX uniq_users_lower_username
  ON users ( lower(username) );
CREATE UNIQUE INDEX uniq_users_lower_email
  ON users ( lower(email) );

CREATE INDEX key_users_invited_by_id
  ON users ( invited_by_id );

CREATE TRIGGER on_users_update_timestamp
  AFTER UPDATE ON users
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

---- DOMAIN TABLES

CREATE TABLE document_types(

  document_type_id domain_positive_integer NOT NULL,
  slug domain_slug NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_document_types_id
    PRIMARY KEY ( document_type_id ),
  CONSTRAINT uniq_document_types_slug
    UNIQUE ( slug )

);

CREATE SEQUENCE seq_document_type_id
  START WITH 1001
  INCREMENT BY 1;

ALTER SEQUENCE seq_document_type_id
  OWNED BY document_types.document_type_id;

ALTER TABLE document_types
  ALTER COLUMN document_type_id
  SET DEFAULT nextval('seq_document_type_id');

CREATE TRIGGER on_document_types_update_timestamp
  AFTER UPDATE ON document_types
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE link_target_types(

  link_target_type_id domain_positive_integer NOT NULL,
  slug domain_slug NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_target_types_id
    PRIMARY KEY ( link_target_type_id ),
  CONSTRAINT uniq_target_types_slug
    UNIQUE ( slug )

);

CREATE SEQUENCE seq_link_target_type_id
  START WITH 1001
  INCREMENT BY 1;

ALTER SEQUENCE seq_link_target_type_id
  OWNED BY link_target_types.link_target_type_id;

ALTER TABLE link_target_types
  ALTER COLUMN link_target_type_id
  SET DEFAULT nextval('seq_link_target_type_id');

CREATE TRIGGER on_target_types_update_timestamp
  AFTER UPDATE ON link_target_types
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE asset_types(

  asset_type_id domain_positive_integer NOT NULL,
  value domain_string_255_nonblank NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_asset_types_id
    PRIMARY KEY ( asset_type_id ),
  CONSTRAINT uniq_asset_types_value
    UNIQUE ( value )

);

CREATE SEQUENCE seq_asset_type_id
  START WITH 1001
  INCREMENT BY 1;

ALTER SEQUENCE seq_asset_type_id
  OWNED BY asset_types.asset_type_id;

ALTER TABLE asset_types
  ALTER COLUMN asset_type_id
  SET DEFAULT nextval('seq_asset_type_id');

CREATE TRIGGER on_asset_types_update_timestamp
  AFTER UPDATE ON asset_types
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE asset_roles(

  asset_role_id domain_positive_integer NOT NULL,
  slug domain_slug NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_asset_roles_id
    PRIMARY KEY ( asset_role_id ),
  CONSTRAINT uniq_asset_roles_slug
    UNIQUE ( slug )

);

CREATE SEQUENCE seq_asset_role_id
  START WITH 1001
  INCREMENT BY 1;

ALTER SEQUENCE seq_asset_role_id
  OWNED BY asset_roles.asset_role_id;

ALTER TABLE asset_roles
  ALTER COLUMN asset_role_id
  SET DEFAULT nextval('seq_asset_role_id');

CREATE TRIGGER on_asset_roles_update_timestamp
  AFTER UPDATE ON asset_roles
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE assessment_types(

  assessment_type_id domain_positive_integer NOT NULL,
  slug domain_slug NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_assessment_types_id
    PRIMARY KEY ( assessment_type_id ),
  CONSTRAINT uniq_assessment_types_slug
    UNIQUE ( slug )

);

CREATE SEQUENCE seq_assessment_type_id
  START WITH 1001
  INCREMENT BY 1;

ALTER SEQUENCE seq_assessment_type_id
  OWNED BY assessment_types.assessment_type_id;

ALTER TABLE assessment_types
  ALTER COLUMN assessment_type_id
  SET DEFAULT nextval('seq_assessment_type_id');

CREATE TRIGGER on_assessment_types_update_timestamp
  AFTER UPDATE ON assessment_types
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE project_roles(

  project_role_id domain_positive_integer NOT NULL,
  slug domain_slug NOT NULL,
  project_mode domain_positive_integer NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_project_roles_id
    PRIMARY KEY ( project_role_id ),
  CONSTRAINT uniq_project_roles_slug
    UNIQUE ( slug ),

  CONSTRAINT check_project_roles_directory
    CHECK(project_mode & 8 <> 0)

);

CREATE SEQUENCE seq_project_role_id
  START WITH 1001
  INCREMENT BY 1;

ALTER SEQUENCE seq_project_role_id
  OWNED BY project_roles.project_role_id;

ALTER TABLE project_roles
  ALTER COLUMN project_role_id
  SET DEFAULT nextval('seq_project_role_id');

CREATE TRIGGER on_project_role_update_timestamp
  AFTER UPDATE ON project_roles
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE release_tags(

  release_tag_id domain_positive_integer NOT NULL,
  slug domain_slug NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_release_tags_id
    PRIMARY KEY ( release_tag_id ),
  CONSTRAINT uniq_release_tags_slug
    UNIQUE ( slug )

);

CREATE SEQUENCE seq_release_tag_id
  START WITH 1001
  INCREMENT BY 1;

ALTER SEQUENCE seq_release_tag_id
  OWNED BY release_tags.release_tag_id;

ALTER TABLE release_tags
  ALTER COLUMN release_tag_id
  SET DEFAULT nextval('seq_release_tag_id');

CREATE TRIGGER on_release_tags_update_timestamp
  AFTER UPDATE ON release_tags
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

---- DATA TABLES

CREATE TABLE user_preferences(

  user_id uuid NOT NULL,
  key domain_string_255_nonblank NOT NULL,
  value domain_string_255_nonblank,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_preferences_user_key
    PRIMARY KEY ( user_id, key ),

  CONSTRAINT for_preferences_user
    FOREIGN KEY ( user_id )
    REFERENCES users ( user_id )

);

CREATE TRIGGER on_preferences_update_timestamp
  AFTER UPDATE ON user_preferences
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE projects(

  project_id uuid DEFAULT uuid_generate_v4() NOT NULL,
  slug domain_slug NOT NULL,

  name domain_string_255_nonblank NOT NULL,
  short_name domain_string_255_nonblank,

  default_mode domain_positive_integer DEFAULT 8 NOT NULL,

  creator_user_id uuid NOT NULL,
  created domain_timestamp NOT NULL,
  updater_user_id uuid,
  updated domain_timestamp,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_projects_id
    PRIMARY KEY ( project_id ),
  CONSTRAINT uniq_projects_slug
    UNIQUE ( slug ),

  CONSTRAINT for_projects_creator
    FOREIGN KEY ( creator_user_id )
    REFERENCES users ( user_id ),
  CONSTRAINT for_projects_updater
    FOREIGN KEY ( updater_user_id )
    REFERENCES users ( user_id )

);

CREATE INDEX key_projects_name
  ON projects ( name );

CREATE INDEX key_projects_public_name
  ON projects ( name )
  WHERE default_mode & 8 != 0; -- visible bit is set

CREATE TRIGGER on_projects_update_timestamp
  AFTER UPDATE ON projects
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE project_user_grants(

  project_id uuid NOT NULL,
  user_id uuid NOT NULL,
  project_role_id domain_positive_integer NOT NULL,

  grantor_user_id uuid NOT NULL,
  created domain_timestamp DEFAULT now() NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_grants_project_user_role
    PRIMARY KEY ( project_id, user_id, project_role_id ),

  CONSTRAINT for_grants_project
    FOREIGN KEY ( project_id )
    REFERENCES projects (project_id),
  CONSTRAINT for_grants_user
    FOREIGN KEY ( user_id )
    REFERENCES users (user_id),
  CONSTRAINT for_grants_role
    FOREIGN KEY ( project_role_id )
    REFERENCES project_roles (project_role_id),
  CONSTRAINT for_grants_grantor
    FOREIGN KEY ( grantor_user_id )
    REFERENCES users (user_id)

);

CREATE INDEX key_grants_user
  ON project_user_grants ( user_id );

CREATE INDEX key_grants_grantor
  ON project_user_grants ( grantor_user_id );

CREATE TRIGGER on_grants_update_timestamp
  AFTER UPDATE ON project_user_grants
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE concepts(

  concept_id uuid DEFAULT uuid_generate_v4() NOT NULL,

  project_id uuid NOT NULL,
  slug domain_slug_long NOT NULL,

  name domain_string_255_nonblank NOT NULL,
  short_name domain_string_255_nonblank,

  creator_user_id uuid NOT NULL,
  created domain_timestamp NOT NULL,
  updater_user_id uuid,
  updated domain_timestamp,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_concepts_id
    PRIMARY KEY ( concept_id ),
  CONSTRAINT uniq_concepts_project_slug
    UNIQUE ( project_id, slug ),

  CONSTRAINT for_concepts_project
    FOREIGN KEY ( project_id )
    REFERENCES projects (project_id),
  CONSTRAINT for_concepts_creator
    FOREIGN KEY ( creator_user_id )
    REFERENCES users (user_id),
  CONSTRAINT for_concepts_updater
    FOREIGN KEY ( updater_user_id )
    REFERENCES users (user_id)

);

CREATE INDEX key_concepts_slug
  ON concepts ( slug );

CREATE INDEX key_concepts_name
  ON concepts ( name );

CREATE INDEX key_concepts_project_name
  ON concepts ( project_id, name );

CREATE TRIGGER on_concepts_update_timestamp
  AFTER UPDATE ON concepts
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE concept_relation_types(

  concept_relation_type_id domain_positive_integer NOT NULL,

  project_id uuid NOT NULL,
  slug domain_slug NOT NULL,

  name domain_string_255_nonblank,
  short_name domain_string_255_nonblank,

  creator_user_id uuid NOT NULL,
  created domain_timestamp NOT NULL,
  updater_user_id uuid,
  updated domain_timestamp,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_con_rel_types_id
    PRIMARY KEY ( concept_relation_type_id ),
  CONSTRAINT uniq_con_rel_types_project_slug
    UNIQUE ( project_id, slug ),

  CONSTRAINT for_con_rel_types_project
    FOREIGN KEY ( project_id )
    REFERENCES projects ( project_id ),
  CONSTRAINT for_con_rel_types_creator
    FOREIGN KEY ( creator_user_id )
    REFERENCES users ( user_id ),
  CONSTRAINT for_con_rel_types_updater
    FOREIGN KEY ( updater_user_id )
    REFERENCES users ( user_id )

);

CREATE INDEX key_con_rel_types_slug
  ON concept_relation_types ( slug );

CREATE INDEX key_con_rel_types_name
  ON concept_relation_types ( name );

CREATE INDEX key_con_rel_types_project_name
  ON concept_relation_types ( project_id, name );

CREATE SEQUENCE seq_concept_relation_type_id
  START WITH 1001
  INCREMENT BY 1;

ALTER SEQUENCE seq_concept_relation_type_id
  OWNED BY concept_relation_types.concept_relation_type_id;

ALTER TABLE concept_relation_types
  ALTER COLUMN concept_relation_type_id
  SET DEFAULT nextval('seq_concept_relation_type_id');

CREATE TRIGGER on_con_rel_types_update_timestamp
  AFTER UPDATE ON concept_relation_types
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE concept_relations(

  project_id uuid NOT NULL,

  concept_id uuid NOT NULL,
  concept_relation_type_id domain_positive_integer NOT NULL,
  related_concept_id uuid NOT NULL,

  creator_user_id uuid NOT NULL,
  created domain_timestamp NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_con_rels_project_concept_type_related
    PRIMARY KEY ( project_id, concept_id, concept_relation_type_id, related_concept_id ),

  CONSTRAINT for_con_rels_concept
    FOREIGN KEY ( concept_id )
    REFERENCES concepts (concept_id),
  CONSTRAINT for_con_rels_type
    FOREIGN KEY ( concept_relation_type_id )
    REFERENCES concept_relation_types (concept_relation_type_id),
  CONSTRAINT for_con_rels_related
    FOREIGN KEY ( related_concept_id )
    REFERENCES concepts (concept_id),
  CONSTRAINT for_con_rels_creator
    FOREIGN KEY ( creator_user_id )
    REFERENCES users (user_id)

);

CREATE INDEX key_con_rels_concept_type_related
  ON concept_relations ( concept_id, concept_relation_type_id, related_concept_id );

CREATE INDEX key_con_rels_project_related
  ON concept_relations ( project_id, related_concept_id );

CREATE INDEX key_con_rels_related
  ON concept_relations ( related_concept_id );

CREATE TRIGGER on_con_rels_update_timestamp
  AFTER UPDATE ON concept_relations
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE entities(

  entity_id uuid DEFAULT uuid_generate_v4() NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,

  CONSTRAINT uniq_entities_id
    PRIMARY KEY ( entity_id )

);

--

-- like assets, sharable across projects

CREATE TABLE locations(

  location_id uuid DEFAULT uuid_generate_v4() NOT NULL,
  value geography NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,

  CONSTRAINT uniq_locations_id
    PRIMARY KEY ( location_id )

);

CREATE INDEX key_locations_value_gist
  ON locations USING GIST( value );

--

CREATE TABLE concept_sets(

  concept_set_id uuid DEFAULT uuid_generate_v4() NOT NULL,

  project_id uuid NOT NULL,

  name domain_string_255_nonblank NOT NULL,
  short_name domain_string_255_nonblank,

  creator_user_id uuid NOT NULL,
  created domain_timestamp NOT NULL,
  updater_user_id uuid,
  updated domain_timestamp,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_con_sets_id
    PRIMARY KEY ( concept_set_id ),

  CONSTRAINT for_con_sets_project
    FOREIGN KEY ( project_id )
    REFERENCES projects (project_id),
  CONSTRAINT for_con_sets_creator
    FOREIGN KEY ( creator_user_id )
    REFERENCES users (user_id),
  CONSTRAINT for_con_sets_updater
    FOREIGN KEY ( updater_user_id )
    REFERENCES users (user_id)

);

CREATE INDEX key_con_sets_project_name
  ON concept_sets ( project_id, name );

CREATE TRIGGER on_con_sets_update_timestamp
  AFTER UPDATE ON concept_sets
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE concept_set_memberships(

  concept_set_id uuid NOT NULL,
  rank domain_natural_integer NOT NULL, -- one-based

  member_concept_set_id uuid,
  member_concept_id uuid,

  creator_user_id uuid NOT NULL,
  created domain_timestamp NOT NULL,
  updater_user_id uuid,
  updated domain_timestamp,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_con_set_mems_set_rank
    PRIMARY KEY ( concept_set_id, rank ),

  CONSTRAINT for_con_set_mems_set
    FOREIGN KEY ( concept_set_id )
    REFERENCES concept_sets ( concept_set_id ),
  CONSTRAINT for_con_set_mems_mem_set
    FOREIGN KEY ( member_concept_set_id )
    REFERENCES concept_sets ( concept_set_id ),
  CONSTRAINT for_con_set_mems_mconcept
    FOREIGN KEY ( member_concept_id )
    REFERENCES concepts ( concept_id ),
  CONSTRAINT for_con_set_mems_creator
    FOREIGN KEY ( creator_user_id )
    REFERENCES users ( user_id ),
  CONSTRAINT for_con_set_mems_updater
    FOREIGN KEY ( updater_user_id )
    REFERENCES users ( user_id ),

  CONSTRAINT check_con_set_mems_union
    CHECK ((CASE WHEN member_concept_set_id IS NOT NULL THEN 1 ELSE 0 END +
            CASE WHEN member_concept_id     IS NOT NULL THEN 1 ELSE 0 END ) = 1)

);

CREATE INDEX key_con_set_mems_mem_set
  ON concept_set_memberships ( member_concept_set_id );

CREATE INDEX key_con_set_mems_mcategeory
  ON concept_set_memberships ( member_concept_id );

CREATE TRIGGER on_con_set_mems_update_timestamp
  AFTER UPDATE ON concept_set_memberships
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

CREATE or replace FUNCTION recursive_concept_sets(top_concept_set_id uuid)
RETURNS TABLE(concept_set_id uuid,
              parent_concept_set_id uuid,
              rank domain_natural_integer,
              project_id uuid,
              name domain_string_255_nonblank,
              short_name domain_string_255_nonblank)
LANGUAGE plpgsql
AS $$
  BEGIN
    RETURN QUERY
    WITH RECURSIVE concept_set_descent_summary AS (

      SELECT cs.concept_set_id, NULL::uuid, NULL::domain_natural_integer, cs.project_id, cs.name, cs.short_name
      FROM concept_sets cs
      WHERE cs.concept_set_id = top_concept_set_id

      UNION

      SELECT cs.concept_set_id, d.concept_set_id, csm.rank, cs.project_id, cs.name, cs.short_name
      FROM concept_set_descent_summary d
      JOIN concept_set_memberships csm
        ON csm.concept_set_id = d.concept_set_id
      JOIN concept_sets cs
        ON cs.concept_set_id = csm.member_concept_set_id
    )
    SELECT * FROM concept_set_descent_summary;
  END;
$$;

--

CREATE TABLE documents(

  document_id uuid DEFAULT uuid_generate_v4() NOT NULL,
  document_type_id domain_positive_integer NOT NULL,
  concept_set_id uuid,
  project_id uuid NOT NULL,

  slug domain_string_255_nonblank, -- TEMPORARY

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_documents_id
    PRIMARY KEY ( document_id ),
  CONSTRAINT uniq_documents_slug
    UNIQUE ( slug ),

  CONSTRAINT for_documents_type
    FOREIGN KEY ( document_type_id )
    REFERENCES document_types ( document_type_id ),
  CONSTRAINT for_documents_cset
    FOREIGN KEY ( concept_set_id )
    REFERENCES concept_sets ( concept_set_id ),
  CONSTRAINT for_documents_project
    FOREIGN KEY ( project_id )
    REFERENCES projects ( project_id )

);

CREATE TRIGGER on_documents_update_timestamp
  AFTER UPDATE ON documents
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE revisions(

  revision_id uuid DEFAULT uuid_generate_v4() NOT NULL,
  document_id uuid NOT NULL,
  parent_revision_id uuid,
  created domain_timestamp DEFAULT now() NOT NULL,
  user_id uuid,
  comments text,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_revisions_id
    PRIMARY KEY ( revision_id ),
  CONSTRAINT uniq_revisions_document_parent
    UNIQUE ( document_id, parent_revision_id ),

  CONSTRAINT for_revisions_document
    FOREIGN KEY ( document_id )
    REFERENCES documents ( document_id ),
  CONSTRAINT for_revisions_parent
    FOREIGN KEY ( parent_revision_id )
    REFERENCES revisions ( revision_id ),
  CONSTRAINT for_revisions_user
    FOREIGN KEY ( user_id )
    REFERENCES users ( user_id )

);

CREATE UNIQUE INDEX uniq_revisions_document_root
  ON revisions ( document_id )
  WHERE parent_revision_id IS NULL;

CREATE INDEX key_revisions_document_created
  ON revisions ( document_id, created );

CREATE INDEX key_revisions_parent
  ON revisions ( parent_revision_id );

CREATE INDEX key_revisions_user_created
  ON revisions ( user_id, created );

CREATE INDEX key_revisions_created
  ON revisions ( created );

CREATE TRIGGER on_revisions_update_timestamp
  AFTER UPDATE ON revisions
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE assets(

  asset_id uuid DEFAULT uuid_generate_v4() NOT NULL,
  asset_type_id domain_positive_integer NOT NULL,
  digest domain_string_32_nonblank NOT NULL,
  content bytea NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_assets_id
    PRIMARY KEY ( asset_id ),
  CONSTRAINT uniq_assets_type_digest
    UNIQUE ( asset_type_id, digest ),

  CONSTRAINT for_assets_type
    FOREIGN KEY ( asset_type_id )
    REFERENCES asset_types ( asset_type_id )

);

CREATE TRIGGER on_assets_update_timestamp
  AFTER UPDATE ON assets
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE revision_asset_roles(

  revision_id uuid NOT NULL,
  asset_id uuid NOT NULL,
  asset_role_id domain_positive_integer NOT NULL,
  title domain_string_255_nonblank NOT NULL,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_rev_asset_roles_rev_role_title
    PRIMARY KEY ( revision_id, asset_role_id, title ),
  CONSTRAINT uniq_rev_asset_roles_rev_asset
    UNIQUE ( revision_id, asset_id ),

  CONSTRAINT for_rev_asset_roles_rev
    FOREIGN KEY ( revision_id )
    REFERENCES revisions ( revision_id ),
  CONSTRAINT for_rev_asset_roles_asset
    FOREIGN KEY ( asset_id )
    REFERENCES assets ( asset_id ),
  CONSTRAINT for_rev_asset_roles_role
    FOREIGN KEY ( asset_role_id )
    REFERENCES asset_roles ( asset_role_id )

);

CREATE TRIGGER on_rev_asset_roles_update_timestamp
  AFTER UPDATE ON revision_asset_roles
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE linkables(

  linkable_id uuid DEFAULT uuid_generate_v4() NOT NULL,

  entity_id uuid,
  concept_id uuid,
  document_id uuid,
  location_id uuid,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_linkables_id
    PRIMARY KEY ( linkable_id ),
  CONSTRAINT uniq_linkables_entity
    UNIQUE ( entity_id ),
  CONSTRAINT uniq_linkables_concept
    UNIQUE ( concept_id ),
  CONSTRAINT uniq_linkables_document
    UNIQUE ( document_id ),
  CONSTRAINT uniq_linkables_location
    UNIQUE ( location_id ),

  CONSTRAINT for_linkables_entity
    FOREIGN KEY ( entity_id )
    REFERENCES entities ( entity_id ),
  CONSTRAINT for_linkables_concept
    FOREIGN KEY ( concept_id )
    REFERENCES concepts ( concept_id ),
  CONSTRAINT for_linkables_document
    FOREIGN KEY ( document_id )
    REFERENCES documents ( document_id ),
  CONSTRAINT for_linkables_location
    FOREIGN KEY ( location_id )
    REFERENCES locations ( location_id ),

  CONSTRAINT check_linkables_union
    CHECK ((CASE WHEN entity_id   IS NOT NULL THEN 1 ELSE 0 END +
            CASE WHEN concept_id  IS NOT NULL THEN 1 ELSE 0 END +
            CASE WHEN document_id IS NOT NULL THEN 1 ELSE 0 END +
            CASE WHEN location_id IS NOT NULL THEN 1 ELSE 0 END) < 2)

);

CREATE TRIGGER on_linkables_update_timestamp
  AFTER UPDATE ON linkables
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

CREATE FUNCTION process_entity_as_linkable()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
  BEGIN

    INSERT INTO linkables (entity_id)
    VALUES (NEW.entity_id);
    RETURN NEW;

  END;
$$;

CREATE FUNCTION process_concept_as_linkable()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
  BEGIN

    INSERT INTO linkables (concept_id)
    VALUES (NEW.concept_id);
    RETURN NEW;

  END;
$$;

CREATE FUNCTION process_document_as_linkable()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
  BEGIN

    INSERT INTO linkables (document_id)
    VALUES (NEW.document_id);
    RETURN NEW;

  END;
$$;

CREATE FUNCTION process_location_as_linkable()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
  BEGIN

    INSERT INTO linkables (location_id)
    VALUES (NEW.location_id);
    RETURN NEW;

  END;
$$;

CREATE TRIGGER on_entities_insert_linkable
  AFTER INSERT ON entities
  FOR EACH ROW
  EXECUTE PROCEDURE process_entity_as_linkable();

CREATE TRIGGER on_concepts_insert_linkable
  AFTER INSERT ON concepts
  FOR EACH ROW
  EXECUTE PROCEDURE process_concept_as_linkable();

CREATE TRIGGER on_documents_insert_linkable
  AFTER INSERT ON documents
  FOR EACH ROW
  EXECUTE PROCEDURE process_document_as_linkable();

CREATE TRIGGER on_locations_insert_linkable
  AFTER INSERT ON locations
  FOR EACH ROW
  EXECUTE PROCEDURE process_location_as_linkable();

--

CREATE TABLE link_types(

  link_type_id domain_positive_integer NOT NULL,

  project_id uuid NOT NULL,
  slug domain_slug NOT NULL,

  name domain_string_255_nonblank,
  short_name domain_string_255_nonblank,

  converse_link_type_id domain_positive_integer,

  link_target_type_id domain_positive_integer NOT NULL,

  domain_concept_id uuid,
  range_concept_id uuid,

  creator_user_id uuid NOT NULL,
  created domain_timestamp NOT NULL,
  updater_user_id uuid,
  updated domain_timestamp,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_link_types_id
    PRIMARY KEY ( link_type_id ),
  CONSTRAINT uniq_link_types_project_slug
    UNIQUE ( project_id, slug ),
  CONSTRAINT uniq_link_types_project_converse
    UNIQUE ( project_id, converse_link_type_id ),

  CONSTRAINT for_link_types_project
    FOREIGN KEY ( project_id )
    REFERENCES projects ( project_id ),
  CONSTRAINT for_link_types_converse
    FOREIGN KEY ( converse_link_type_id )
    REFERENCES link_types ( link_type_id ),
  CONSTRAINT for_link_types_target
    FOREIGN KEY ( link_target_type_id )
    REFERENCES link_target_types ( link_target_type_id ),
  CONSTRAINT for_link_types_domain
    FOREIGN KEY ( domain_concept_id )
    REFERENCES concepts ( concept_id ),
  CONSTRAINT for_link_types_range
    FOREIGN KEY ( range_concept_id )
    REFERENCES concepts ( concept_id ),
  CONSTRAINT for_link_types_creator
    FOREIGN KEY ( creator_user_id )
    REFERENCES users ( user_id ),
  CONSTRAINT for_link_types_updater
    FOREIGN KEY ( updater_user_id )
    REFERENCES users ( user_id )

);

CREATE INDEX key_link_types_slug
  ON link_types ( slug );

CREATE INDEX key_link_types_name
  ON link_types ( name );

CREATE INDEX key_link_types_project_name
  ON link_types ( project_id, name );

CREATE SEQUENCE seq_link_type_id
  START WITH 1001
  INCREMENT BY 1;

ALTER SEQUENCE seq_link_type_id
  OWNED BY link_types.link_type_id;

ALTER TABLE link_types
  ALTER COLUMN link_type_id
  SET DEFAULT nextval('seq_link_type_id');

CREATE TRIGGER on_link_type_update_timestamp
  AFTER UPDATE ON link_types
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE revision_links(

  revision_id uuid NOT NULL,

  link_type_id domain_positive_integer NOT NULL,

  target_title domain_string_255_nonblank NOT NULL,

  target_linkable_id uuid,
  target_value domain_string_255_nonblank,

  rank domain_natural_integer, -- one-based

  time_range domain_string_255_nonblank,
  beginning bigint, -- +/- 272B years, inclusive
  ending bigint, -- exclusive

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT uniq_rev_links_revision_ltype_ttitle
    PRIMARY KEY ( revision_id, link_type_id, target_title ),

  CONSTRAINT for_rev_links_revision
    FOREIGN KEY ( revision_id )
    REFERENCES revisions ( revision_id ),
  CONSTRAINT for_rev_links_type
    FOREIGN KEY ( link_type_id )
    REFERENCES link_types ( link_type_id ),
  CONSTRAINT for_rev_links_target
    FOREIGN KEY ( target_linkable_id )
    REFERENCES linkables ( linkable_id ),

  CONSTRAINT check_rev_links_union
    CHECK ((CASE WHEN target_linkable_id IS NOT NULL THEN 1 ELSE 0 END +
            CASE WHEN target_value       IS NOT NULL THEN 1 ELSE 0 END ) < 2)

);

CREATE INDEX key_rev_links_revision_ltype_rank
  ON revision_links ( revision_id, link_type_id, rank );

CREATE INDEX key_rev_links_revision_ltype_beginning 
  ON revision_links( revision_id, link_type_id, beginning );

CREATE INDEX key_rev_links_revision_beginning
  ON revision_links ( revision_id, beginning );

CREATE INDEX key_rev_links_target
  ON revision_links ( target_linkable_id );

CREATE INDEX key_rev_links_target_beginning
  ON revision_links ( target_linkable_id, beginning );

CREATE INDEX key_rev_links_type_value
  ON revision_links ( link_type_id, target_value );

CREATE INDEX key_rev_links_type_target
  ON revision_links ( link_type_id, target_linkable_id );

CREATE TRIGGER on_rev_links_update_timestamp
  AFTER UPDATE ON revision_links
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

--

CREATE TABLE revision_assessments(

  revision_id uuid NOT NULL,
  assessment_type_id domain_positive_integer NOT NULL,
  user_id uuid NOT NULL,
  created domain_timestamp DEFAULT now() NOT NULL,
  comments text,

  row_created domain_timestamp DEFAULT now() NOT NULL,
  row_updated domain_timestamp,

  CONSTRAINT for_rev_assessments_revision
    FOREIGN KEY ( revision_id )
    REFERENCES revisions ( revision_id ),
  CONSTRAINT for_rev_assessments_user
    FOREIGN KEY ( user_id )
    REFERENCES users ( user_id ),
  CONSTRAINT for_rev_assessments_type
    FOREIGN KEY ( assessment_type_id )
    REFERENCES assessment_types ( assessment_type_id )

);

CREATE INDEX key_rev_assessments_revision_created
  ON revision_assessments ( revision_id, created );

CREATE INDEX key_rev_assessments_user_created
  ON revision_assessments ( user_id, created );

CREATE TRIGGER on_rev_assessments_update_timestamp
  AFTER UPDATE ON revision_assessments
  FOR EACH ROW
  EXECUTE PROCEDURE process_row_updated_timestamp();

