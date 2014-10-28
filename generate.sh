# mvn dependency:copy-dependencies
java -classpath target/dependency/jooq-3.3.0.jar:target/dependency/jooq-meta-3.3.0.jar:target/dependency/jooq-codegen-3.3.0.jar:target/dependency/postgresql-9.3-1101-jdbc41.jar:. org.jooq.util.GenerationTool /jooq-generate.xml
