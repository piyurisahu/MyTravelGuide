# MyTravelGuide
Introduction
My Travel Guide is an android app designed for traveler’s. It provides comprehensive information about popular city, places to visit, hotel rate and weather information.
Key Features and Components
*Activities
	*activity_main.xml
o	activity_city_information.xml

•	I have addressed explicit intent concept when activity_main.xml call to activity_city_information.xml.
•	Fragments
o	fragment_descrition_layout.xml
o	fragment_image_layout.xml
o	fragment_share_place_layout.xml
o	activity_city_information has fragment holder which contains one of the above fragments depends on user selected icon.
•	Implicit intent is getting used when user share city information
•	Main screen uses reclyclerView to show list of cities with images. Xml file: - list_row.xml
•	Image fragment uses listView to show list of places to visit in selected city.
•	Toast is getting used in main screen
•	Broadcast receiver is used when user turn on/off flight mode.
Flow of the App
Application starts with listing the popular cities. As show in fig below. This is the main screen (MainActivity)
