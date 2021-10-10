drop table if exists himly_dubbo_account;

create table himly_dubbo_account (
    `id` int(11) NOT NULL,
    `name` varchar(64) not null ,
    `us_wallet` int(11) not null ,
    `cny_wallet` int(11) not null,
    primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;;