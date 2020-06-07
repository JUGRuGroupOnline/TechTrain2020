
package main

import (
	"fmt"
	"log"
	"errors"
	"net/http"
        "os"
	"github.com/gorilla/mux"
	"github.com/go-resty/resty"
)

func main() {
	router := mux.NewRouter()
	router.HandleFunc("/", GetHelloWorld).Methods("GET")
	log.Fatal(http.ListenAndServe("0.0.0.0:" + os.Getenv("PORT"), router))
}

func GetHelloWorld(w http.ResponseWriter, r *http.Request) {
	client := resty.New()
        resp, err := client.R().Get("http://" + os.Getenv("SOURCE_URL"))
        if err != nil {
                log.Fatal(err)
        }
        if resp.String() != "Мы" {
                log.Fatal(errors.New("Expected \"Мы\", got " + resp.String()))
	} 
	fmt.Fprintf(w, resp.String() + " сломали")
}

