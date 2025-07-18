Diego Regalado
July 18th, 2025
CPSC-39
Final Programming Project

"Golf Club Manager"

The Golf Club Organizer is a terminal based Java program that allows users to manage a virtual set of golf clubs. It loads clubs from a file, allows user input to add, view, search, delete, and sort clubs, and tracks usage statistics. It is useful for keeping an organized virtual “warehouse” of golf clubs and simulating a golf bag manager.

Recursive Search
	•	Searches the list of clubs by name recursively.
	•	Starts at index 0 and checks each club one by one.
	•	Returns the matching club or null if not found.

    Sort by Loft
	•	Uses Comparator.comparingDouble() to sort clubs by loft.

    Usage Leaderboard
	•	Uses a HashMap to count uses.
	•	Sorts the map by value (descending) to show most-used clubs.
