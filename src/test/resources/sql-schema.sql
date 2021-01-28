drop table if exists `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

drop table if exists `items`;

CREATE TABLE IF NOT EXISTS `items`  (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`value` DECIMAL(5,2) NOT NULL,
	PRIMARY KEY (`id`)
    );
    
drop table if exists `orders` 
    
 CREATE TABLE IF NOT EXISTS `orders` (  
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`fk_customers_id` INT NOT NULL,
	`order_value` DOUBLE,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`fk_customers_id`) REFERENCES customers(`id`) ON DELETE CASCADE
    );  
    
drop table if exists `orders_items`

CREATE TABLE IF NOT EXISTS `orders_items` (
	`fk_orders_id` INT NOT NULL,
	`fk_items_id` INT NOT NULL,
	FOREIGN KEY (`fk_orders_id`) REFERENCES orders(`id`) ON DELETE CASCADE,
	FOREIGN KEY (`fk_items_id`) REFERENCES items(`id`) ON DELETE CASCADE);