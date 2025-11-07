# About SmartAthlete
SmartAthlete utilizes Jakarta EE, Jakarta Faces, Prime Faces, CDI Beans, and MySQL to implement real-time data-driven graphs from a database of athletes, coaches, injuries, and sports. SmartAthlete can be used to give young athletes with high risk factors more specialized and preventive care.<br/>
Developed for Nexus DevDays HealthTech 2025. Ultimately it was not chosen for the finals, however it remains one of my best works that I am proud of.<br/>
![Injuries by Age](https://github.com/mayfontenot/SmartAthlete/blob/main/screenshots/stats_injuries_by_age.png)
![Injuries by Sport](https://github.com/mayfontenot/SmartAthlete/blob/main/screenshots/stats_injuries_by_sport.png)
![Athlete Injury Edit Select](https://github.com/mayfontenot/SmartAthlete/blob/main/screenshots/athlete_edit_select.png)
![Athlete Injuries](https://github.com/mayfontenot/SmartAthlete/blob/main/screenshots/athlete_injuries.png)
![Injuries by Coach](https://github.com/mayfontenot/SmartAthlete/blob/main/screenshots/stats_injuries_by_coach.png)
![Athlete Injury Insert Calendar](https://github.com/mayfontenot/SmartAthlete/blob/main/screenshots/athlete_insert_calendar.png)
![Login](https://github.com/mayfontenot/SmartAthlete/blob/main/screenshots/login.png)

## Installation:
1. Create a MySQL database named "db_health_injuries" and import the included MySQL_database/db_health_injuries.sql file
3. Open the project folder in your IDE and configure utilities.MySQLConnector to match your MySQL server, DEFAULT config is (IP: localhost, port: 8889)
5. Build and deploy the WAR file to the web
