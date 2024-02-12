CREATE TABLE `Order` (
                         orderId BIGINT PRIMARY KEY AUTO_INCREMENT,
                         member_id BIGINT,
                         delivery_id BIGINT,
                         orderDate DATETIME,
                         orderStatus VARCHAR(255),
                         FOREIGN KEY (member_id) REFERENCES Member(member_id),
                         FOREIGN KEY (delivery_id) REFERENCES Delivery(delivery_id)
);

CREATE TABLE Order_OrderItem (
                                 order_id BIGINT,
                                 orderItem_id BIGINT,
                                 PRIMARY KEY (order_id, orderItem_id),
                                 FOREIGN KEY (order_id) REFERENCES `Order`(orderId),
                                 FOREIGN KEY (orderItem_id) REFERENCES OrderItem(orderitem_id)
);

CREATE TABLE Member (
                        member_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        memberName VARCHAR(255),
                        street VARCHAR(255),
                        city VARCHAR(255),
                        zipcode VARCHAR(255)
);

CREATE TABLE Item (
                      item_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      itemName VARCHAR(255),
                      itemPrice INT,
                      stockQuantity INT,
                      datatype VARCHAR(255)
);

CREATE TABLE Item_Category (
                               item_id BIGINT,
                               category_id BIGINT,
                               PRIMARY KEY (item_id, category_id),
                               FOREIGN KEY (item_id) REFERENCES Item(item_id),
                               FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

CREATE TABLE Category (
                          category_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255),
                          parent_id BIGINT,
                          FOREIGN KEY (parent_id) REFERENCES Category(category_id)
);

CREATE TABLE category_item (
                               category_id BIGINT,
                               item_id BIGINT,
                               PRIMARY KEY (category_id, item_id),
                               FOREIGN KEY (category_id) REFERENCES Category(category_id),
                               FOREIGN KEY (item_id) REFERENCES Item(item_id)
);

CREATE TABLE Delivery (
                          delivery_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          street VARCHAR(255),
                          city VARCHAR(255),
                          zipcode VARCHAR(255),
                          order_id BIGINT,
                          FOREIGN KEY (order_id) REFERENCES `Order`(orderId)
);

ALTER TABLE Item ADD COLUMN artist VARCHAR(255);
ALTER TABLE Item ADD COLUMN etc VARCHAR(255);
ALTER TABLE Item ADD COLUMN author VARCHAR(255);
ALTER TABLE Item ADD COLUMN isbn VARCHAR(255);
ALTER TABLE Item ADD COLUMN director VARCHAR(255);
ALTER TABLE Item ADD COLUMN actor VARCHAR(255);
