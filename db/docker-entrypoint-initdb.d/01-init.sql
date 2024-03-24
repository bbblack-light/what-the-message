CREATE USER "game_user" WITH LOGIN PASSWORD 'postgres';

CREATE DATABASE "game" WITH OWNER = 'game_user'
encoding = 'utf8'
lc_collate = 'en_US.utf8'
lc_ctype = 'en_US.utf8'
connection limit = -1
template template1;

ALTER database "game" OWNER TO "game_user";

\c game;
CREATE SCHEMA "game";

ALTER schema "game" OWNER TO "game_user";

GRANT ALL PRIVILEGES ON SCHEMA "game" TO "game_user";

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA "game" TO "game_user";

GRANT USAGE ON SCHEMA "game" TO "game_user";

CREATE USER "game_app" WITH LOGIN PASSWORD 'postgres';

GRANT USAGE ON SCHEMA "game" TO "game_app";