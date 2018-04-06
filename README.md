# demo
api for users

List of api:
- **rest/api/users/{id}** - Get by Id 
    - ***params***:
        {id} - id of user
    - ***return***: user in json format
- **rest/api/users/create** - create user
    - ***params***:
        [name] - name of user
        [password] - password of user
    - ***return***: id of created user
- **rest/api/users/edit/{id}** - edit user
    - ***params***:
        {id} - id of editable user
        [name] - name of user
        [password] - password of user
    - ***return***: httpstatus
- **rest/api/users/delete/{id}** - delete user
    - ***params***:
        {id} - id of user
    - ***return***: http status