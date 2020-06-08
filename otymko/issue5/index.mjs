import express from "express";
import http from "http";

const app = express();
const serviceEntrypoint = process.env["SERVICE_ENTRYPOINT"];
const standartAnswer = "Мы сломали твой код,";

if (!serviceEntrypoint) {
    throw new Error("Переменная среды не задана: SERVICE_ENTRYPOINT");
}

app.get("/", async(_req, res) => {

    http.get(serviceEntrypoint, (previousService) => {
        let previousBody = "";
        previousService.on("data", data => {
            previousBody += data;
        });
        previousService.on("end", () => {
            if (previousBody !== standartAnswer) {
                res.status(500);
                res.send(`Ответ не соответствует ожидаемому значению: ${standartAnswer}`);
                return;
            }
            res.send(`${previousBody} уронили`);
        });
    });

});

app.listen(3000);