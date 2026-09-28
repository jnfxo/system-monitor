function updateDashboard() {
    const mockDiskUsage = Math.floor(Math.random() * 90) + 5;

    const diskText = document.getElementById("disk-text");
    const diskBar = document.getElementById("disk-bar");

    diskText.innerText = mockDiskUsage + "% User";
    diskBar.style.width = "%" ;


    if (mockDiskUsage > 80) {
        diskBar.style.backgroundcolor = "#f75a68";
    } else {
        diskBar.style.backgroundcolor = "#00b37e";
    }
}

updateDashboard();

setInterval(updateDashboard, 3000);
