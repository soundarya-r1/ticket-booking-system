--Sample records
--===============================
-- USERS
--===============================
insert into users (email, name, password, phone_number, role)
values ('admin@gmail.com', 'admin', 'pass', '89898989898', 'ADMIN');

insert into users (email, name, password, phone_number, role)
values ('charlie@gmail.com', 'charlie', 'pass', '89898989898', 'CUSTOMER');

insert into users (email, name, password, phone_number, role)
values ('bob@gmail.com', 'bob', 'pass', '89898989898', 'CUSTOMER');

insert into users (email, name, password, phone_number, role)
values ('avni@gmail.com', 'avni', 'pass', '89898989898', 'CUSTOMER');

--===============================
-- EVENTS
--===============================
insert into event (name, description, event_type, location, event_date, total_seats, available_seats, status)
values ('Rock Concert', 'Live rock performance by popular band', 'Concert', 'Mumbai', '2025-12-20T19:30:00', 100, 100, 'ACTIVE');

insert into event (name, description, event_type, location, event_date, total_seats, available_seats, status)
values ('Movie Night', 'Latest Kannada blockbuster', 'Movie', 'Mysore', '2025-10-05T20:00:00', 50, 50, 'ACTIVE');

insert into event (name, description, event_type, location, event_date, total_seats, available_seats, status)
values ('Cricket Match', 'India vs Australia T20', 'Sports', 'Bengaluru', '2025-11-15T18:00:00', 500, 500, 'ACTIVE');

--===============================
-- BOOKINGS
--===============================
-- Users: 1=admin, 2=charlie, 3=bob, 4=avni
-- Events: 1=Rock Concert, 2=Movie Night, 3=Cricket Match

-- CONFIRMED bookings
insert into booking (user_id, event_id, seats_booked, status, total_amount)
values (2, 1, 2, 'CONFIRMED', 1000.00);

insert into booking (user_id, event_id, seats_booked, status, total_amount)
values (3, 2, 3, 'CONFIRMED', 1500.00);

insert into booking (user_id, event_id, seats_booked, status, total_amount)
values (4, 3, 4, 'CONFIRMED', 4000.00);

-- CANCELLED bookings
insert into booking (user_id, event_id, seats_booked, status, total_amount)
values (2, 2, 1, 'CANCELLED', 500.00);

insert into booking (user_id, event_id, seats_booked, status, total_amount)
values (3, 1, 2, 'CANCELLED', 1000.00);

-- PENDING bookings
insert into booking (user_id, event_id, seats_booked, status, total_amount)
values (4, 1, 1, 'PENDING', 500.00);

insert into booking (user_id, event_id, seats_booked, status, total_amount)
values (2, 3, 5, 'PENDING', 5000.00);
