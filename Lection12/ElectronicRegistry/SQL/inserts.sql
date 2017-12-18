START TRANSACTION;
USE hotel;

INSERT INTO room (price, capacity, status, section, rating) VALUES
(150, 4, 'free', 'single', 9),
(243, 3, 'free', 'standart', 7),
(200, 5, 'free', 'lux', 10);

INSERT INTO guest (name, surname, fk_room_id) VALUES
  ('Ivan', 'Ivanov', 1),
  ('Peter', 'Petrov', 2),
  ('Ann', 'Petrova', 2),
  ('John', 'Fool', 3);

INSERT INTO service (name, price, section, start_date, final_date, fk_guest_id) VALUES
  ('Service1', 55.5, 'mandatory', '2003-01-08', '2016-06-06', 1),
  ('Service2', 33.4, 'food', '2014-05-05', '2015-05-05', 2),
  ('Service3', 240, 'place', '2013-05-08', '2014-07-15', 4);

INSERT INTO registration (start_date, final_date, fk_room_id, fk_guest_id) VALUES
  ('2017-01-08', '2017-06-06', 1, 1),
  ('2017-05-08', '2017-05-25', 2, 2),
  ('2017-05-08', '2017-05-25', 2, 3),
  ('2017-02-01', '2017-03-10', 3, 4);

COMMIT