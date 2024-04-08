CREATE TABLE session (
    uuid uuid primary key,
    player_uuid uuid,
    CONSTRAINT fk_session_player FOREIGN KEY (player_uuid) REFERENCES player (uuid)
);