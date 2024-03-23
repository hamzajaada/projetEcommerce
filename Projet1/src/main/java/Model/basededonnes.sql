CREATE TABLE categories(
<<<<<<< HEAD
                id INT PRIMARY KEY,
                categorie varchar(30)
=======
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           categorie VARCHAR(30)
>>>>>>> b855993589bb469dca46efc3b0e4fdd3b2a78e80
); CREATE TABLE articles(
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            designation VARCHAR(30),
                            prix FLOAT,
                            stock INT,
                            category_id INT,
                            FOREIGN KEY(category_id) REFERENCES categories(id),
                            photo VARCHAR(30)
   ); CREATE TABLE clients(
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              nom VARCHAR(30),
                              prenom VARCHAR(30),
                              adresse VARCHAR(30),
                              codePostal INT,
                              ville VARCHAR(30),
                              tel VARCHAR(30),
                              motPasse VARCHAR(30)
      ); CREATE TABLE commandes(
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   client_id INT,
                                   dateCommande DATE,
                                   FOREIGN KEY(client_id) REFERENCES clients(id)
         ); CREATE TABLE lignesCommande(
                                           commande_id INT,
                                           article_id INT,
                                           qteCde INT,
                                           FOREIGN KEY(commande_id) REFERENCES commandes(id),
                                           FOREIGN KEY(article_id) REFERENCES articles(id)
            );