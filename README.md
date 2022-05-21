# Back-end for personal portfolio (Spring Boot)
[Front-end for this project can be found here.](https://github.com/Jaycedam/portfolio-frontend)
<br/>
All API requests start with api/
<br/>
eg: ../api/projects/starred

## Project API
> - projects -> Find all projects (GET, public)
> - projects/starred -> Find starred (boolean) projects (GET, public)
> - project/save -> Save new project (POST, authorized)
> - project/update/{id} -> Update project by id inside path (PUT, authorized)
> - project/delete/{id} -> Delete project by id inside path (DELETE, authorized)

## Area API
> - areas -> Find all areas (GET, public)
> - area/save -> Save new area (POST, authorized)
> - area/update/{id} -> Update area by id inside path (PUT, authorized)
> - area/delete/{id} -> Delete area by id inside path (DELETE, authorized)

## User API
> - users -> Find all areas (GET, authorized)
> - user/save -> Save new user (POST, authorized)
> - role/save -> Save new ROLE eg: "ROLE_ADMIN" (POST, authorized)
> - user/add-role -> Assign existing role to user (POST, authorized)
> - token/refresh -> Refresh auth token (GET, authorized)
