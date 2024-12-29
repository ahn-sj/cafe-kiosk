DROP TABLE IF EXISTS menus;
CREATE TABLE menus (
    menu_id   BIGSERIAL PRIMARY KEY,
    menu_name VARCHAR(64) NOT NULL
);
COMMENT ON COLUMN menus.menu_id IS '메뉴 ID';
COMMENT ON COLUMN menus.menu_name IS '메뉴 이름';
