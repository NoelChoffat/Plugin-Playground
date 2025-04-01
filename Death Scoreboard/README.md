# DeathScoreboard
This was my first try to make a Scoreboard.
## What does it do
It gets the Deaths of all Player of the Server throug the Statistics Deaths while someone dies it takes 1 Tick to Update this event into the Scoreboard. I have found no other way to do it whitout the delay currently(Wait for the *Edit).
### *Edit
So i took some time to overthink this while the first solution gave me the right thing what I wanted it bothered me that I waited one tick (20ms). So I changed it that everytime you Join the Server the Joinplayer event is called and gets all your Deaths which are in your Statistics. Then it counts from there + 1 Death for everytime you die with the help of the DeatheventListerner.
