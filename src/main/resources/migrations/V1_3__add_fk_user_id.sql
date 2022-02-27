ALTER TABLE linkshortener.urls
ADD COLUMN user_id bigint,
add constraint constraint_user_id
FOREIGN KEY (user_id)
REFERENCES linkshortener.users (id);