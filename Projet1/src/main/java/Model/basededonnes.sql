CREATE TABLE categories(
                           id INT PRIMARY KEY,
                           categorie varchar(30)
); CREATE TABLE articles(
                            id INT PRIMARY KEY,
                            designation varchar(30),
                            prix FLOAT,
                            stock INT,
                            category_id INT,
                            FOREIGN KEY(category_id) REFERENCES categories(id),
                            photo varchar(30)
   ); CREATE TABLE clients(
                              id INT PRIMARY KEY,
                              nom varchar(30),
                              prenom varchar(30),
                              adresse varchar(30),
                              codePostal INT,
                              ville varchar(30),
                              tel varchar(30),
                              motPasse varchar(30)
      ); CREATE TABLE commandes(
                                   id INT PRIMARY KEY,
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