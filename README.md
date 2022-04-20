# But it works on my machine

Developer usually says it, then let's put it's machine on production.

This project is a small experiment to sample podman-compose and how good is it
replacing docker-compose.

## Project structure

Here i am trying to make the container thing as much transparent as possible.

Therefore it's a regular java project, a very hones frontend web project and we
will make use of a regular relational database.

It should be very possible to run everything without the need of any containers
at all, but this is not the point.

## Environment setup

It was tested on fedora 35, podman and podman-compose from official repo:

```bash
sudo dnf install podman-compose podman 
```

Also will need java-jdk 11 and node 14 with npm installed.

## Do i really need containers for development

One could simply install everything by hand on bare metal and call it a day.

But i want to explore the luxury to not spend time configuring an environment.

## Caveats

So far, i see plenty of advantages using it to setup a production environment.
But for day to day development i have concerns.

- volumes can be tricky. we might need to expose volumes to avoid loss of data,
  but at the same time volume itself can be destructive.
- user permissions are a real issue. Even being rootless and using random uids
  and gids for their containerized files, it still be a problem when doing
  modifications form outside of the container.

Seeing a lot of material about uid/gid remapping, but no elegant solution yet.
