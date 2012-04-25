CREATE VIEW `kpi_db`.`kpi_graph_daily` AS 
select `d`.`id` AS `id`,
    `d`.`current_day` AS `current_day`,
    `d`.`description` AS `description`,
    `d`.`scheduled_orders` AS `scheduled_orders`,
    `d`.`finished_orders` AS `finished_orders`,
    `d`.`failures_orders` AS `failures_orders`,
	`d`.`id_week` AS `id_week`,`d`.`state` AS `state` 
    from `kpi_daily` `d` 
    where (`d`.`current_day` = 
    (select max(`e`.`current_day`) from `kpi_daily` `e` 
    where (`e`.`id_week` = `d`.`id_week`)))

CREATE VIEW `kpi_daily_sum_hours` AS 
select 	`a`.`id_daily` AS `id_daily`,
		`b`.`ID` AS `id_delay`,
		`b`.`NAME` AS `name_daily`,
		sum(`a`.`num_hours`) AS `num_hours` 
from (`kpi_daily_delay` `a` join `kpi_delay` `b`) 
where ((`b`.`ID` = `a`.`id_delay`) and (`a`.`num_hours` > 0)) 
group by `a`.`id_daily`,`b`.`ID`,`b`.`NAME` 
order by sum(`a`.`num_hours`) desc	