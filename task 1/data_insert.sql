START TRANSACTION;
USE lection_9;

INSERT INTO product (maker, model, type) VALUES
  ('Acer', 'Acer v3-571g', 'Laptop'),
  ('Acer', 'Acer Aspire ES1', 'Laptop'),
  ('Asus', 'Vivo Aio 2000', 'PC'),
  ('Asus', 'Zen AiO Pro', 'PC'),
  ('Asus', 'A4110', 'PC'),
  ('Canon', 'F3000', 'Printer'),
  ('HP', '22-b0', 'PC'),
  ('HP', 'HP 255', 'Laptop'),
  ('HP', 'HP 15-ac159ur', 'Laptop'),
  ('HP', 'Zen AiO', 'PC'),
  ('HP', 'ENVY 24-n271ur', 'PC'),
  ('Lenovo', 'Lenovo ideaPad', 'Laptop'),
  ('Lenovo', 'Lenovo Z51-70', 'Laptop'),
  ('Lenovo', 'Lenovo Y700', 'Laptop'),
  ('MSI Gaming', '25GE', 'PC'),
  ('Xerox', 'd2000', 'Printer'),
  ('MSI Gaming', 'GT83VR', 'PC'),
  ('MSI Gaming', 'MSI GL62', 'PC'),
  ('HP', 'HP4545', 'Laptop'),
  ('HP', 'J1200', 'Printer');

INSERT INTO pc (code, model, speed, ram, hd, cd, price) VALUES
  (136, '25GE', 3000, 4096, 500, '4x', 365),
  (2750, '22-b0', 3500, 6144, 750, '12x', 450),
  (3192, 'Vivo Aio 2000', 4000, 8192, 1000, '16x', 685),
  (1548, 'Zen AiO', 5000, 3072, 500, '8x', 430),
  (2751, 'ENVY 24-n271ur', 3500, 6144, 750, '12x', 450),
  (3193, 'GT83VR', 3500, 8192, 1000, '16x', 785),
  (3195, 'MSI GL62', 4500, 8192, 1500, '24x', 995),
  (1363, 'A4110', 3500, 8192, 750, '8x', 525),
  (265, 'Zen AiO Pro', 3100, 4096, 500, '8x', 430);

INSERT INTO laptop (code, model, speed, ram, hd, price, screen) VALUES
  (1845, 'Acer v3-571g', 2500, 8192, 240, 720, 15),
  (214, 'HP4545', 2100, 6144, 500, 630, 15),
  (550, 'Lenovo ideaPad', 3000, 16384, 250, 1020, 17),
  (1843, 'Lenovo Z51-70', 2600, 8192, 500, 653, 17),
  (2141, 'Lenovo Y700', 2800, 8192, 500, 800, 15),
  (5501, 'HP 255', 2100, 4048, 500, 550, 15),
  (1844, 'HP 15-ac159ur', 2500, 8192, 1000, 860, 15),
  (2142, 'Acer Aspire ES1', 2600, 8192, 750, 810, 15);

INSERT INTO printer (code, model, color, type, price) VALUES
  (1255, 'D2000', 'y', 'Lazer', 210),
  (952, 'F3000', 'n', 'Matrix', 652),
  (322, 'J1200', 'y', 'Jet', 150);

COMMIT;