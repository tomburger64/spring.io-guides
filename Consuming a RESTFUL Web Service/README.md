# https://spring.io/guides/gs/consuming-rest

There are 2 apps:
- "qoters-master" that gets the quotes (not made by me), run it in a seperate terminal with "mvwn spring-boot-run" (windows) and go to [this url](http://localhost:8080/api/random)
- "consuming rest" that consumes some rest ressources form it (made with the guide), run in terminal (same run command as above) and you'll see the quote appear on the last line

**They both work together**
The one I built is waiting for some json feedback to be in a 2 layer structure, something like this:
{
   type: "success",
   value: { (↓ "2nd" layer ↓)
      id: 10,
      quote: "Really loving Spring Boot, makes stand alone Spring apps easy."
   }
}

## Sum up of learned stuff (still need practice but I get it):
- How to make a logger (used to show the quote in the terminal)
- Purpose of a spring bean (not that I get when to use or not use one)
- Learned about RestTemplate and how to make one (a bit foggy)
- Got the difference between CommandLineRunner and using a controller 
- Got what a runner method is

I get it, but I have to remind myself of what I saw in this guide everytime I open it, I even made a "visual help" you can see for yourself if you care
I'll try to make it by myself, that'll probably help