TRUNCATE team_employee RESTART IDENTITY CASCADE;
TRUNCATE techlog RESTART IDENTITY CASCADE;
TRUNCATE employee RESTART IDENTITY CASCADE;
TRUNCATE team RESTART IDENTITY CASCADE;
TRUNCATE technology RESTART IDENTITY CASCADE;


/*
	EMPLOYEE
*/
INSERT INTO public.employee(
            cluster, employeedate, fullname, email, address, sex)
    VALUES ('Back', 'Jul 1, 2016', 'Bogdan A', 'BogdanA@tss-yonder.com', 'UBC3 - tss-tonder', 'Male');

INSERT INTO public.employee(
            cluster, employeedate, fullname, email, address, sex)
    VALUES ('Back', 'Jul 2, 2016', 'Bogdan B', 'BogdanA@tss-yonder.com', 'UBC3 - tss-tonder', 'Male');

INSERT INTO public.employee(
            cluster, employeedate, fullname, email, address, sex)
    VALUES ('Front', 'Jul 3, 2016', 'Bogdan C', 'BogdanA@tss-yonder.com', 'UBC3 - tss-tonder', 'Male');

INSERT INTO public.employee(
            cluster, employeedate, fullname, email, address, sex)
    VALUES ('Front', 'Jul 4, 2016', 'Bogdan D', 'BogdanA@tss-yonder.com', 'UBC3 - tss-tonder', 'Male');

INSERT INTO public.employee(
            cluster, employeedate, fullname, email, address, sex)
    VALUES ('Dev-Ops', 'Jul 5, 2016', 'Bogdan E', 'BogdanA@tss-yonder.com', 'UBC3 - tss-tonder', 'Male');

INSERT INTO public.employee(
            cluster, employeedate, fullname, email, address, sex)
    VALUES ('Dev-Ops', 'Jul 6, 2016', 'Bogdan F', 'BogdanA@tss-yonder.com', 'UBC3 - tss-tonder', 'Male');


/*
	TEAM
*/
INSERT INTO public.team(
            "name", nbofmembers)
    VALUES ('Team A', 3);

INSERT INTO public.team(
            "name", nbofmembers)
    VALUES ('Team B', 3);

INSERT INTO public.team(
            "name", nbofmembers)
    VALUES ('Team C', 2);

/*
	TECHNOLOGY
*/
INSERT INTO public.technology(name)
    VALUES ('Java');

INSERT INTO public.technology(name)
    VALUES ('Hibernate');

INSERT INTO public.technology(name)
    VALUES ('Spring');

INSERT INTO public.technology(name)
    VALUES ('JSF');

INSERT INTO public.technology(name)
    VALUES ('Primefaces');

INSERT INTO public.technology(name)
    VALUES ('CSS');

INSERT INTO public.technology(name)
    VALUES ('Javascript');

INSERT INTO public.technology(name)
    VALUES ('Python');

INSERT INTO public.technology(name)
    VALUES ('C');

INSERT INTO public.technology(name)
    VALUES ('C++');

INSERT INTO public.technology(name)
    VALUES ('C#');

INSERT INTO public.technology(name)
    VALUES ('Angular');

INSERT INTO public.technology(name)
    VALUES ('DB');

INSERT INTO public.technology(name)
    VALUES ('Office Word');

INSERT INTO public.technology(name)
    VALUES ('Office Excel');

/*
	TEAM-EMPLOYEE
*/
INSERT INTO public.team_employee(
            "date", employeeid, teamid)
    VALUES ('Jul 1, 2016', 1, 1);

INSERT INTO public.team_employee(
            "date", employeeid, teamid)
    VALUES ('Jul 1, 2016', 1, 2);

INSERT INTO public.team_employee(
            "date", employeeid, teamid)
    VALUES ('Jul 2, 2016', 2, 1);

INSERT INTO public.team_employee(
            "date", employeeid, teamid)
    VALUES ('Jul 3, 2016', 3, 2);

INSERT INTO public.team_employee(
            "date", employeeid, teamid)
    VALUES ('Jul 4, 2016', 4, 2);

INSERT INTO public.team_employee(
            "date", employeeid, teamid)
    VALUES ('Jul 5, 2016', 5, 3);

INSERT INTO public.team_employee(
            "date", employeeid, teamid)
    VALUES ('Jul 6, 2016', 6, 1);

INSERT INTO public.team_employee(
            "date", employeeid, teamid)
    VALUES ('Jul 6, 2016', 6, 3);



/*
	TechLog
*/

/* employee 1*/
INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (1, 1, 'Jul 6, 2016', 2);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (1, 1, 'Jul 10, 2016', 3);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (1, 2, 'Jul 6, 2016', 3);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (1, 3, 'Jul 6, 2016', 3);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (1, 4, 'Jul 6, 2016', 2);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (1, 5, 'Jul 6, 2016', 4);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (1, 9, 'Jul 6, 2016', 1);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (1, 13, 'Jul 6, 2016', 3);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (1, 15, 'Jul 6, 2016', 5);

/* employee 2 */
INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (2, 1, 'Jul 6, 2016', 2);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (2, 1, 'Jul 8, 2016', 3);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (2, 1, 'Jul 10, 2016', 4);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (2, 1, 'Jul 6, 2017', 3);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (2, 3, 'Jul 6, 2016', 5);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (2, 4, 'Jul 6, 2016', 1);

INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (2, 10, 'Jul 6, 2016', 2);

/* employee 3 */
INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (3, 7, 'Jul 6, 2016', 2);

/* employee 4 */
INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (4, 8, 'Jul 6, 2016', 2);

/* employee 5 */
INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (5, 9, 'Jul 6, 2016', 2);

/* employee 6 */
INSERT INTO public.techlog(
             idemployee, idtechnology,"date", rate)
    VALUES (6, 11, 'Jul 6, 2016', 2);
