create table order_item (
        order_item_id integer not null,
        order_item_status smallint check (order_item_status between 0 and 5),
        price float(53),
        quantity integer,
        created timestamp(6),
        order_id varchar(255) not null,
        product_id varchar(255),
        primary key (order_item_id, order_id)
    )