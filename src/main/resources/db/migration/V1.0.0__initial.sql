CREATE TABLE `role` (
  `role_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `role_uuid` varchar(36) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(255)
);

CREATE TABLE `users` (
  `user_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `user_uuid` varchar(36) NOT NULL,
  `username` varchar(50) NOT NULL,
  `created_at` date NOT NULL,
  `deleted_at` date,
  `role` bigint NOT NULL,
  `credential` bigint NOT NULL
);

CREATE TABLE `credentials` (
  `credential_id` bigint PRIMARY KEY NOT NULL,
  `credential_uuid` varchar(36) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `verified` bool DEFAULT false,
  `verify_token` varchar(36) NOT NULL,
  `created_at` date NOT NULL
);

CREATE TABLE `sessions` (
  `session_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `session_uuid` varchar(36) NOT NULL,
  `verified` bool DEFAULT false,
  `createdAt` date NOT NULL,
  `user` bigint NOT NULL
);

CREATE TABLE `publications` (
  `publication_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `publication_uuid` varchar(36) NOT NULL,
  `body` varchar(255),
  `author` bigint NOT NULL
);

CREATE TABLE `resources` (
  `resource_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `resource_uuid` varchar(36) NOT NULL,
  `resource_url` varchar(255) NOT NULL,
  `resource_type` varchar(255)
);

CREATE TABLE `publication_resources` (
  `publication_resource_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `publication` bigint,
  `resource` bigint
);

CREATE TABLE `streams` (
  `stream_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `stream_uuid` varchar(36) NOT NULL,
  `stream_token` varchar(36),
  `viewers_count` bigint,
  `likes_count` int,
  `publication` bigint
);

CREATE TABLE `stream_resources` (
  `stream_resource_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `stream` bigint NOT NULL,
  `resource` bigint NOT NULL
);

CREATE TABLE `comments` (
  `comment_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `comment_uuid` varchar(36) NOT NULL,
  `body` varchar(255),
  `author` bigint,
  `publication` bigint,
  `stream` bigint
);

CREATE TABLE `likes` (
  `like_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `like_uuid` varchar(36) NOT NULL,
  `user_id` bigint,
  `publication` bigint,
  `stream` bigint
);

ALTER TABLE `users` ADD FOREIGN KEY (`role`) REFERENCES `role` (`role_id`);

ALTER TABLE `users` ADD FOREIGN KEY (`credential`) REFERENCES `credentials` (`credential_id`);

ALTER TABLE `sessions` ADD FOREIGN KEY (`user`) REFERENCES `users` (`user_id`);

ALTER TABLE `publications` ADD FOREIGN KEY (`author`) REFERENCES `users` (`user_id`);

ALTER TABLE `publication_resources` ADD FOREIGN KEY (`publication`) REFERENCES `publications` (`publication_id`);

ALTER TABLE `publication_resources` ADD FOREIGN KEY (`resource`) REFERENCES `resources` (`resource_id`);

ALTER TABLE `streams` ADD FOREIGN KEY (`publication`) REFERENCES `publications` (`publication_id`);

ALTER TABLE `stream_resources` ADD FOREIGN KEY (`stream`) REFERENCES `streams` (`stream_id`);

ALTER TABLE `stream_resources` ADD FOREIGN KEY (`resource`) REFERENCES `resources` (`resource_id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`author`) REFERENCES `users` (`user_id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`publication`) REFERENCES `publications` (`publication_id`);

ALTER TABLE `comments` ADD FOREIGN KEY (`stream`) REFERENCES `streams` (`stream_id`);

ALTER TABLE `likes` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `likes` ADD FOREIGN KEY (`publication`) REFERENCES `publications` (`publication_id`);

ALTER TABLE `likes` ADD FOREIGN KEY (`stream`) REFERENCES `streams` (`stream_id`);
