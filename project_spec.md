# **EZRecipe**

## Table of Contents

1. [App Overview](#App-Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Build Notes](#Build-Notes)

## App Overview

### Description 

EZRecipe is a mobile app that provides tons of recipes for anyone who needs some help cooking.The home screen has a search bar, a favorite button, and a recycler view that shows a list of recipes. Each item in the recycler view has a picture of dish, a dish title, and summary. Users can browse recipes in the main screen, tap any recipe item, and go to the detailed view screen to see details of the recipe, which includes dish picture, dish title, ingredients, prep time, and making process.Users can also look up recipes by entering ingredient or cuisine name in the search bar on the main screen. On the detailed view screen, there is a toggleable "favorite" button at the bottom. Users can save their favorite recipes. When users quit the app and reopen it,users can still see their previously saved recipes by tapping the favorite button on the home screen. Users can delete saved recipes either by delete the recipe in the favorite section, or by toggle the "favorite" button at the bottom of the detailed view.

### App Evaluation

<!-- Evaluation of your app across the following attributes -->

- **Category:** Health & Fitness, Lifestyle
- **Mobile:** Compared to using a laptop or computer, it is more convient to browse or search recipes on cell phones when someone cooks a meal in the kitchen.
- **Story:** This app is a helper to anyone who cooks. If users have some ingredients at home, users can look up recipes by searching ingredient names. 
- **Market:** There is a huge mareket for this app because everyone needs to eat, and many people love to cook. Statistics published by kitcheninfinity.com in May 2023 show that more than 93% of Americans cook at least 1x per week.(https://kitcheninfinity.com/cooking-statistics/)
Most users of this app would be adults. There might be more female users than male users, because more moms cook at home than dads.
- **Habit:** An average user would open and use this app 2-3 times a week. An average user would browse and search recipes using the app. An average user can also create a list of their own favorite recipes with the help of this app.
- **Scope:** This app has a well-formed scope. It utilizes tastyAPI. We should be able to finish basic required aspects of the app by the deadline. A stripped-down version of this app is still interesting to build.


## Product Spec

### 1. User Features (Required and Optional)

Required Features:

- **User can browse recipes.**
- **User can search recipes by ingredients.**
- **User can click recipe picure or summary to see details.**
- **User can save or unsave a recipe as a favorite recipe by toggleable "favorite" button at the bottom of the details screen.**
- **User can see a list of saved favorite recipes by clicking favorite button on home screen.**
- **User can delete a saved recipe from the favorite section.** 

Stretch Features:

- **User can search recipes by cuisine type or dish title.**
- **User can see videos of the making process by clicking video links in the detailed screen.**
- **Users can search recipe using voice commands.**

### 2. Chosen API(s)

- **list first API endpoint here**
  - **https://tasty.p.rapidapi.com/recipes/list?from=0&size=20&tags=under_30_minutes&rapidapi-key={yourkey}**
  


### 3. User Interaction

Required Feature

- **user scrolls recyclerview up and down at home screen **
  - => **to browse recipes**
- **user inputs ingredient in search bar at home screen to search recipes **
  - => **recipes containing the searched ingredient display on screen.**
- **User taps dish picture or summary on home screen **
  - => **Display detailed view of a specific recipe which includes dish picture, recipe title, ingredients,prep time, and instructions for making process**

- **User taps toggleable 'favorite' button at the bottom of the detailed view screen of a specific recipe **
  - => **The recipe is adde to/deleted from favorite section**
 
- **User taps 'favorite' button on home screen **
  - => **Saved recipes by user display in favorite section.**

- **User taps a recipe in favorite section **
  - => **User enters detailed view of the recipe.**

- **User long-tap a recipe in favorite section **
  - => **User see option to delete this recipe from favorite section.**
  
 

## Wireframes

![wireframe ](https://github.com/pod23and101fall23/EZRecipe/assets/114531168/3d6d82bb-b781-4888-a02c-a96309d3aee1)


<!-- Add picture of your hand sketched wireframes in this section -->
<img src="![wireframe ](https://github.com/pod23and101fall23/EZRecipe/assets/114531168/3d6d82bb-b781-4888-a02c-a96309d3aee1)" width=600>

### [BONUS] Digital Wireframes & Mockups

![1](https://github.com/pod23and101fall23/EZRecipe/assets/114531168/f3cb9724-eab1-40de-be2f-201390cb93c6)
![2](https://github.com/pod23and101fall23/EZRecipe/assets/114531168/6fb303eb-4472-4474-a89c-d67ceae8dfc2)
![3](https://github.com/pod23and101fall23/EZRecipe/assets/114531168/41e83330-e712-44cb-ad49-a1b5a627322b)


<img src="![1 ](https://github.com/pod23and101fall23/EZRecipe/assets/114531168/bf6f053d-21cb-4007-8e89-921f1aa78d66)" width=50>
<img src="![2 ](https://github.com/pod23and101fall23/EZRecipe/assets/114531168/d5970875-a77b-4a0c-be79-01093029b308)" width=50>
<img src="![3 ](https://github.com/pod23and101fall23/EZRecipe/assets/114531168/b76f0160-7dfd-43d7-9b46-ddf6c93094c3)" width=50>

### [BONUS] Interactive Prototype

## Build Notes

Here's a place for any other notes on the app, it's creation 
process, or what you learned this unit!  

For Milestone 2, include **2+ Videos/GIFs** of the build process here!

## License

Copyright **2023** **pod23and101fall23**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
