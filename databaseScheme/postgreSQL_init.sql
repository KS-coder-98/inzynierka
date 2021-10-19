CREATE TABLE "user" (
  "id" SERIAL PRIMARY KEY,
  "nick" varchar,
  "first_name" varchar,
  "last_name" varchar,
  "user_details_id" int,
  "contact_id" int
);

CREATE TABLE "user_details" (
  "id" SERIAL PRIMARY KEY,
  "date_of_birth" date,
  "type_of_members" varchar
);

CREATE TABLE "contact" (
  "id" SERIAL PRIMARY KEY,
  "city" varchar,
  "street" varchar,
  "house_number" int,
  "street_number" int,
  "post_code" varchar,
  "phone_number" varchar,
  "phone_area_code" varchar,
  "email" varchar
);

CREATE TABLE "conference_room" (
  "id" SERIAL PRIMARY KEY,
  "name" varchar,
  "description" varchar,
  "equipment" int,
  "capasity" int,
  "indentifier" int,
  "equipment_id" int
);

CREATE TABLE "equipment" (
  "id" SERIAL PRIMARY KEY,
  "name" varchar,
  "description" varchar
);

CREATE TABLE "reservations" (
  "id" SERIAL PRIMARY KEY,
  "event_organiser" int,
  "start_time" datetime,
  "end_time" datetime,
  "event_members" int,
  "conference_room" int
);

ALTER TABLE "reservations" ADD FOREIGN KEY ("conference_room") REFERENCES "conference_room" ("id");

ALTER TABLE "reservations" ADD FOREIGN KEY ("event_organiser") REFERENCES "user" ("id");

ALTER TABLE "reservations" ADD FOREIGN KEY ("event_members") REFERENCES "user" ("id");

ALTER TABLE "conference_room" ADD FOREIGN KEY ("equipment_id") REFERENCES "equipment" ("id");

ALTER TABLE "user_details" ADD FOREIGN KEY ("id") REFERENCES "user" ("user_details_id");

ALTER TABLE "contact" ADD FOREIGN KEY ("id") REFERENCES "user" ("contact_id");
