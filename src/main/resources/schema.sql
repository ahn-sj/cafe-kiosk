DROP TABLE IF EXISTS operation_hours;
DROP TABLE IF EXISTS menu_categories;
DROP TABLE IF EXISTS menu_options;
DROP TABLE IF EXISTS menus;
DROP TABLE IF EXISTS shop;

/** 가게 */
CREATE TABLE shop
(
    shop_id    BIGSERIAL                           NOT NULL,
    shop_name  VARCHAR(64)                         NOT NULL,
    created_at TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (shop_id)
);
COMMENT ON COLUMN shop.shop_id IS '가게 ID';
COMMENT ON COLUMN shop.shop_name IS '가게 이름';
COMMENT ON COLUMN shop.created_at IS '생성일';
COMMENT ON COLUMN shop.updated_at IS '수정일';

-----------------------------

/** 가게 운영시간 */
CREATE TABLE operation_hours
(
    shop_id     BIGINT      NOT NULL,
    day_of_week VARCHAR(10) NOT NULL,
    start_time  TIME        NOT NULL,
    end_time    TIME        NOT NULL,
    PRIMARY KEY (shop_id, day_of_week),
    CONSTRAINT fk_operation_hours_shop_id FOREIGN KEY (shop_id) REFERENCES shop (shop_id)
);
COMMENT ON COLUMN operation_hours.shop_id IS '가게 ID';
COMMENT ON COLUMN operation_hours.day_of_week IS '요일';
COMMENT ON COLUMN operation_hours.start_time IS '운영 시작 시간';
COMMENT ON COLUMN operation_hours.end_time IS '운영 종료 시간';

-----------------------------

/** 메뉴 카테고리 */
CREATE TABLE menu_categories
(
    menu_category_id          BIGSERIAL   NOT NULL,
    shop_id                   BIGINT      NOT NULL,
    menu_category_name        VARCHAR(32) NOT NULL,
    menu_category_description VARCHAR(32) NOT NULL,
    created_at TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (menu_category_id),
    CONSTRAINT fk_menu_categories_shop_id FOREIGN KEY (shop_id) REFERENCES shop (shop_id)
);
COMMENT ON COLUMN menu_categories.menu_category_id IS '메뉴 카테고리 ID';
COMMENT ON COLUMN menu_categories.shop_id IS '가게 ID';
COMMENT ON COLUMN menu_categories.menu_category_name IS '메뉴 카테고리 이름';
COMMENT ON COLUMN menu_categories.menu_category_description IS '메뉴 카테고리 설명';
COMMENT ON COLUMN menu_categories.created_at IS '생성일';
COMMENT ON COLUMN menu_categories.updated_at IS '수정일';

-----------------------------

/** 메뉴 */
CREATE TABLE menus
(
    menu_id          BIGSERIAL                           NOT NULL,
    menu_name        VARCHAR(64)                         NOT NULL,
    price            DOUBLE PRECISION                    NOT NULL,
    menu_category_id BIGSERIAL                           NOT NULL,
    created_at       TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at       TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (menu_id)
);
COMMENT ON COLUMN menus.menu_id IS '메뉴 ID';
COMMENT ON COLUMN menus.menu_name IS '메뉴 이름';
COMMENT ON COLUMN menus.price IS '가격';
COMMENT ON COLUMN menus.menu_category_id IS '메뉴 카테고리 ID';
COMMENT ON COLUMN menus.created_at IS '생성일';
COMMENT ON COLUMN menus.updated_at IS '수정일';

-----------------------------

/** 메뉴 옵션 */
CREATE TABLE menu_options
(
    menu_option_id   BIGSERIAL                              NOT NULL,
    menu_id          BIGSERIAL                              NOT NULL,
    created_at       TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at       TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (menu_option_id),
    CONSTRAINT fk_menu_options_menu_id FOREIGN KEY (menu_id) REFERENCES menus (menu_id)
);
COMMENT ON COLUMN menu_options.menu_option_id IS '메뉴 옵션 ID';
COMMENT ON COLUMN menu_options.menu_id IS '메뉴 ID';
COMMENT ON COLUMN menu_options.created_at IS '생성일';
COMMENT ON COLUMN menu_options.updated_at IS '수정일';

-----------------------------

/** 메뉴 옵션 항목 */
CREATE TABLE menu_option_items
(
    menu_option_item_id BIGSERIAL                              NOT NULL,
    option_name         VARCHAR(64)                            NOT NULL,
    extra_price         DOUBLE PRECISION                       NOT NULL,
    menu_option_id      BIGSERIAL                              NOT NULL,
    created_at          TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at          TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (menu_option_item_id),
    CONSTRAINT fk_menu_option_items_menu_option_id FOREIGN KEY (menu_option_id) REFERENCES menu_options (menu_option_id)
);
COMMENT ON COLUMN menu_option_items.menu_option_item_id IS '메뉴 옵션 항목 ID';
COMMENT ON COLUMN menu_option_items.option_name IS '옵션 이름';
COMMENT ON COLUMN menu_option_items.extra_price IS '추가 가격';
COMMENT ON COLUMN menu_option_items.menu_option_id IS '메뉴 옵션 ID';
COMMENT ON COLUMN menu_option_items.created_at IS '생성일';
COMMENT ON COLUMN menu_option_items.updated_at IS '수정일';
