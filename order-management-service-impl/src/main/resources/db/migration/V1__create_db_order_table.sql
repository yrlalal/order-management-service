create table db_order (
        order_status smallint check (order_status between 0 and 5),
        created timestamp(6),
        customer_id varchar(255),
        order_id varchar(255) not null,
        primary key (order_id)
    )