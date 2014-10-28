# Lenzenslijper

Lenzenslijper (Dutch for "lens grinder") web service is a Tomcat web application
providing access to a versioned, semantic document data store built on
PostgreSQL.

Lenzenslijper is a work in progress, and is provided as-is, as open source
software under the provisions of the BSD license. Patches are welcome!

## Data model

The Lenzenslijper data model is based on Projects, Concepts, Entities,
Documents, Revisions, Assets, and Links.

### Projects

Projects enable users to selectively and collaboratively publish content.
Projects may be public or private. Projects establish a default set of
permissions for associated content. Users may be granted additional
permissions on an individual basis.

### Concepts

Concepts are ideas that can be used to classify content. Concepts can collected
in ordered sets, or structured hierarchically, with some concepts narrowing or
broadening other concepts.

### Entities

Entities are semantically-distinct topics such as people, places, works of
reference and events. An Entity belongs to a type (modeled as a Concept) such
as "Event", "Person", or "Book". Other attributes of Entities are defined by
Documents.

### Documents

Documents are articles or collections. A Document may offer a definitive
view of a Entity, or may reference other Documents. Each Document belongs
to a Project.

### Revisions

Revisions are versions of Documents. A Revision may be published or private,
according to the editorial workflow of the Project its Document belongs to.
Revisions are composed from Assets and Links.

#### Assets

Assets are media of specific types such as markdown text and images. Assets are
distinguished by role and name.

#### Links

Links a Document with other Documents or assert the values of properties
such as names and dates. Links are also used to associate a collection with its
members.

## Configuration and deployment

### Installing the database schema

Lenzenslijper requires a PostgreSQL database instance (tested on
PostgreSQL 9.3.2) with the plpgsql, uuid-ossp and postgis extensions
available.

Given such an instance, install the database by running these commands:

    psql -h {HOST} -u {USER} {INSTANCE} < src/main/resources/structure.sql
    psql -h {HOST} -u {USER} {INSTANCE} < src/main/resources/domain.sql
    psql -h {HOST} -u {USER} {INSTANCE} < src/main/resources/views.sql

### Configuring the Tomcat servlet container

Lenzenslijper requires Tomcat (version >= 7.0.4.2) due to a dependency on
Tomcat's container-provided CORS filter.

#### JNDI data source

Configure a JNDI data source in the "GlobalNamingResources" section of the
"conf/server.xml" file like this:

    <Resource name="psql/bonecp/lenzenslijper"
              auth="Container"
              type="javax.sql.DataSource"
              factory="com.jolbox.bonecp.BoneCPDataSource"
              driverClassName="org.postgresql.Driver"
              jdbcUrl="jdbc:postgresql://{HOST}:{PORT}/{INSTANCE}"
              username="{USERNAME}"
              password="{PASSWORD}"
              defaultAutoCommit="false" />

Then ensure that the PostgreSQL/bonecp dependencies are available to the
Tomcat container. You can download the dependency jars by running the
Maven "dependency:copy-dependencies" goal:

    mvn dependency:copy-dependencies

This will install all of the jars needed by the project into the
"target/dependency" directory. Copy the following jars into the "common",
"server" or "shared" loader paths, according to the "conf/catalina.properties"
configuration:

    postgresql
    bonecp
    guava
    slf4j-api
    slf4j-log4j
    log4j

Then, copy "src/main/resources/log4j.properties" into the "classes" directory
of the desired loader.

Restart tomcat in order to activate the new configuration.

### Packaging the WAR

To build the WAR file, run the Maven "package" goal:

    mvn package

The WAR file, ready for deployment, is built here:

    target/lenzenslijper-1.0-SNAPSHOT.war

## API

### Public API

The following resources are available without authentication.

#### GET /public/projects
Optional parameters:
* sort (default: "name"; "recent")
* limit (default: 100)
* offset (default: 0)

A list of public projects

#### GET /public/projects/{SLUG}

Detail about a public project

#### GET /public/documents
Optional parameters:
* project (slug)
* prefix (prefix of title)
* document\_type (e.g. "perspective", "collection")
* entity\_type (concept slug)
* concept (associated concept slug)
* sort (default: "name"; "recent")
* limit (default: 100)
* offset (default: 0)

A list of public documents

#### GET /public/linked/documents/{LINK-ID}

Detail about the latest public revision of a document

#### GET /public/linked/documents/{LINK-ID}/revisions/{REVISION-ID}

Detail about a specific revision of a public document

#### GET /public/linked/documents/{LINK-ID}/members
Optional parameters:
* concept (associated concept slug)
* limit (default: 100)
* offset (default: 0)

A list of members of the latest public revision of a collection document

#### GET /public/linked/documents/{LINK-ID}/revisions/{REVISION-ID}/members
Optional parameters:
* concept (associated concept slug)
* limit (default: 100)
* offset (default: 0)

A list of members of a specific revision of a public collection document

#### GET /public/linked/documents/{LINK-ID}/geography

GeoJSON geometry associated with latest public revision of a document

#### GET /public/linked/documents/{LINK-ID}/revisions/{REVISION-ID}/geography

GeoJSON geometry associated with a specific revision of a public document

#### GET /public/titles
Optional parameters:
* prefix
* limit (default: 100)
* offset (default: 0)

A list of public document titles

#### GET /public/concepts
Optional parameters:
* project (slug)
* parent (concept slug)
* prefix (concept name prefix)
* limit (default: 100)
* offset (default: 0)

A list of concepts

#### GET /public/concept-sets/{SET-ID}

Detail on a concept set

#### GET /public/link-types
Optional parameters:
* domain (concept slug)
* range (concept slug)
* target-type (target type slug, e.g. "document")

A list of link types

### Authorized API

The following resources require BASIC authentication.

#### GET /auth/projects
Optional parameters:
* limit (default: 100)
* offset (default: 0)

A list of projects the authenticated users is authorized to write to.

#### POST /auth/revisions
Fields:
* project (slug)
* document\_type (slug, if document is new)
* parent\_revision\_id (if document already exists)
* entity\_type (if entity is new)
* entity\_id (if entity already exists)
* title
* links (array, see Links fields)
* assets (array, see Assets fields)
* comments (optional)

Links fields:
* type (slug)
* title
* target\_linkable\_id (if applicable to link type)
* value (if applicable to link type)
* rank (optional)
* time\_range
* beginning
* end

Assets fields:
* type
* role
* title
* content

Creates a new document revision.

#### POST /auth/revisions/{REVISION-ID}/assessments
Fields:
* assessment\_type (e.g. "publish")
* comments (optional)

Creates a new assesment for the given document revision.

# Terms

Copyright (c) 2014 Fokus LLC. See LICENSE.txt for further details.

