# But it works on my machine

Developer usually says it, then let's put its machine on production.

This project is a small experiment to sample podman-compose and how good is it
replacing docker-compose.

## Project structure

Here I am trying to make the container thing as much transparent as possible.

Therefore, it's a regular java project, a very honest frontend web project, and
we will make use of a regular relational database.

It should be very possible to run everything without the need of any containers
at all, but this is not the point.

## Environment setup

It was tested on fedora 35, podman and podman-compose from official repo:

```bash
sudo dnf install podman-compose podman 
```

Also will need java-jdk 11 and node 14 with npm installed.

## Do I really need containers for development

One could simply install everything by hand on bare metal and call it a day.

But I want to explore the luxury to not spend time configuring an environment.

## Tested hosts

So far, it works on:

- fedora 35 with podman-compose
- kde neon (ubuntu) with official docker-compose

It fails on:

- windows 10 with docker-compose
- mac-book air (2021) with m1 chip with docker-compose
- mac-book air (2021) with m1 chip with podman-compose from brew

Containers are not java. There is no _write once, run everywhere_ here. It is
important to create an image supported by the host, otherwise it will not work.

## Caveats

So far, I see plenty of advantages using it to set up a production environment.
But for day to day development I have concerns.

- Volumes can be tricky. We might need to expose volumes to avoid loss of data,
  but at the same time volume itself can
  be [destructive](https://docs.docker.com/storage/bind-mounts/#configure-the-selinux-label)
  . Pay much attention configuring it.
- Remember, once you build your local container, it has a copy of your actual
  workspace somewhere else. unless you get the volume configuration right, take
  care to not lose precious data.
- Build the kotlin project image with gradle is surprisingly slow.
- The --watch-fs on gradle simply doesn't work.
- The network_mode can be tricky. The app sees db correctly, but web still needs
  to hit localhost to find app.
- Running it with `docker-compose` instead of `podman-compose`, your server
  shall never user links and network_mode together. In our example, _db_ and
  _app_ can use links, but _web_ goes with network_mode: "host" in order to work
  properly.

~~Seeing a lot of material about uid/gid remapping, but no elegant solution
yet.~~ A good solution came with correct selinux flag.

## Usage

Spin podman-compose the same way you could spin up docker-compose:

```bash
podman-compose up
```

Key configurations are present on [docker-compose.yaml](./docker-compose.yaml)
file itself and inside the root .env file; web project has one, but it's for
bare metal development only.

## Status

This sample project is a quite honest hello world on container-based
development, with a few issues to solve, but can be easily tweaked for better
development experience.
