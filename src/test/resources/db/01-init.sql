CREATE USER "game_user" WITH LOGIN PASSWORD 'postgres';

ALTER database "game" OWNER TO "game_user";

CREATE SCHEMA "game";

ALTER schema "game" OWNER TO "game_user";

GRANT ALL PRIVILEGES ON SCHEMA "game" TO "game_user";

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA "game" TO "game_user";

GRANT USAGE ON SCHEMA "game" TO "game_user";