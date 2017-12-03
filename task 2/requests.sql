/* task 1 */
SELECT model, speed, hd FROM pc WHERE price < 500;

/* task 2 */
SELECT maker FROM product WHERE type = 'Printer';

/* task 3 */
SELECT model, ram, screen FROM laptop WHERE price > 1000;

/* task 4 */
SELECT * FROM printer WHERE color = 'y';

/* task 5 */
SELECT model, speed, hd FROM pc WHERE cd IN (12, 24) AND  price < 600;

/* task 6 */
SELECT maker, speed FROM product p, laptop l WHERE p.model = l.model AND l.hd >= 10;

/* task 7 */
SELECT product.model, price FROM product, laptop WHERE product.model = laptop.model AND product.maker = 'Lenovo'
  UNION
  SELECT product.model, price FROM product, laptop WHERE product.model = laptop.model AND product.maker= 'HP'
  UNION
  SELECT product.model, price FROM product, laptop WHERE product.model = laptop.model AND product.maker = 'Acer';

/* task 8 */
SELECT maker FROM product WHERE type = 'PC';

/* task 9 */
SELECT maker FROM product, pc WHERE product.model = pc.model AND pc.speed >= 4500;

/* task 10 */
SELECT model, price FROM printer WHERE price = (SELECT max(price) FROM printer);

/* task 11 */
SELECT round(avg(speed)) AS Speed_Avg_Pc FROM pc;

/* task 12 */
SELECT round(avg(speed)) AS Speed_Avg_Laptop FROM laptop WHERE price >= 1000;

/* task 13 */
SELECT round(avg(speed)) AS Speed_Avg_Pc FROM product, pc WHERE product.model = pc.model AND product.maker = 'Asus'
  UNION
  SELECT round(avg(speed)) AS Speed_Avg_Pc FROM product, pc WHERE product.model = pc.model AND product.maker = 'MSI Gaming'
  UNION
  SELECT round(avg(speed)) AS Speed_Avg_Pc FROM product, pc WHERE product.model = pc.model AND product.maker = 'HP';

/* task 14 */
SELECT speed, round(avg(price)) AS Price_Avg_Pc FROM pc GROUP BY speed;

/* task 15 */
SELECT hd FROM pc GROUP BY hd HAVING count(*) >= 2;

/* task 16 */
SELECT max(model), min(model) FROM pc GROUP BY speed, ram HAVING count(*) >= 2;

/* task 17 */
SELECT DISTINCT product.type, laptop.model, laptop.speed FROM product, laptop WHERE product.type = 'Laptop'
  AND laptop.speed < (SELECT min(speed) FROM pc);

/* task 18 */
SELECT maker, min(price) AS Min_Price FROM product, printer WHERE product.model = printer.model AND printer.color = 'y' GROUP BY maker;

/* task 19 */
SELECT maker, round(avg(screen)) AS Screen_Avg FROM product p, laptop l WHERE p.model = l.model GROUP BY maker;

/* task 20 */
SELECT maker, count(model) AS Count_Models FROM product WHERE product.type = 'PC' GROUP BY maker HAVING count(*) >= 3;

/* task 21 */
SELECT maker, max(price) AS Max_Price FROM product, pc WHERE product.model = pc.model GROUP BY maker;

/* task 22 */
SELECT speed, round(avg(price)) AS Price_Avg FROM pc GROUP BY speed HAVING speed > 600;

/* task 23 */
SELECT DISTINCT maker FROM product WHERE type = 'Laptop' AND maker IN
  (SELECT maker FROM product WHERE type = 'PC' AND maker IN
  (SELECT maker FROM pc, laptop WHERE pc.speed >=750 and laptop.speed >=750));

/* task 24 */
SELECT DISTINCT model FROM laptop WHERE laptop.price = (SELECT max(price) FROM laptop)
  UNION
  SELECT model FROM pc WHERE pc.price = (SELECT max(price) FROM pc)
  UNION
  SELECT model FROM printer WHERE printer.price = (SELECT max(price) FROM printer);

/* task 25 */
SELECT DISTINCT maker FROM product WHERE type = 'Printer' AND maker IN
  (SELECT maker FROM product JOIN pc ON product.model = pc.model WHERE type = 'PC' AND
  ram = (SELECT min(ram) FROM pc) AND pc.speed = (SELECT max(speed) FROM pc));