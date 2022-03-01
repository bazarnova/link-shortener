ALTER TABLE linkshortener.links
add constraint fk_created_by
FOREIGN KEY (created_by)
REFERENCES linkshortener.users (id);