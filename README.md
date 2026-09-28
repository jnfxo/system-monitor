# Unix System Performance Dashboard 
A lightweight full-stack dashboard that tracks real-time computer stats (like hard drive space) 
I built this project to learn how a backend web server connects to real oeprting system hardware data without relying on massive frameworks

## How it works
**Backend:** Built using pure **Java**. It uses `ProcessBuilder` to run native Unix terminal commands (`df -h`), parses the raw text string into clean JSON data, and hosts it on a local HTTP server.
**Frontend:** Built with **JavaScript, HTML, and CSS**. It uses (`setInterval`) to periodically grab the data and update modern dark-mode CSS progress bar smoothly.
**DevOps/Automation:** Includes a Unix shell script (`build.sh`) to automate compiling the Java files and launching the server in one step.

## Project Layout 
`/backend/src/SystemServer.java`: Runs the OS terminal commands and parses text.
`/backend/src/SimpleServer.java`: Sets up the network server and creates the data API route.
`/backend/build.sh` : Simple shell script to compile and run the app.
`/frontend/` : Clean web page layout (`index.html`, `syle.css`, `app.js`) to display stats.

## How to Run it Locally
To compile and run the backend server, open your terminal and run:

```bash
cd backend
chmod +x build.sh
./build.sh
```