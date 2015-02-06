LOCK TABLES `rest_tweets`.`tweets` WRITE;

INSERT INTO `rest_tweets`.`tweets`
(id_tweets, author, message, date)
VALUES
  (9831683518, 'NagaSadow',
   'The Light Side chose Linux cause it has the power to liberate everyone. The dark Side chose it cause this power is unlimited',
   '2014-05-04 05:04:42'),
  (843516834, 'ElrosMinyatur',
   'On Elenna we founded the most beautiful realm that could exist, too bad we destroyed it all by madness!',
   '2014-12-01 09:30:42'),
  (9843516846, 'd_adams',
   'What will the second most powerful computer answer if a mouse comes looking for some stupid answer ?',
   '2014-10-10 10:42:42');

UNLOCK TABLES;