INSERT INTO shop (shop_name)
VALUES ('메가커피');

INSERT INTO operation_hours (shop_id, day_of_week, start_time, end_time)
VALUES (1, 'MONDAY', '09:00:00', '22:00:00'),
       (1, 'TUESDAY', '09:00:00', '22:00:00'),
       (1, 'WEDNESDAY', '09:00:00', '22:00:00'),
       (1, 'THURSDAY', '09:00:00', '22:00:00'),
       (1, 'FRIDAY', '09:00:00', '22:00:00'),
       (1, 'SATURDAY', '09:00:00', '22:00:00'),
       (1, 'SUNDAY', '09:00:00', '22:00:00');

INSERT INTO menu_categories (menu_category_id, shop_id, menu_category_name, menu_category_description)
VALUES (1, 1, '음료', '음료 메뉴'),
       (2, 1, '디저트', '디저트 메뉴');

INSERT INTO menus (menu_name, price, menu_category_id)
VALUES ('아메리카노', 3000, 1),
       ('카페라떼', 3500, 1),
       ('카페모카', 4000, 1),
       ('티라미수', 5000, 2),
       ('치즈케이크', 4500, 2);