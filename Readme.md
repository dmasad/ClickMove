ClickMove
==========

ClickMove is a very simple engine for a tactical spaceship combat game, written mostly as a project to build up my Java skills.

Package Overview
-----------------

ClickMove tries to keep the underlying world model separate from the graphics interface. In practice, I haven't always managed to ahere to this. 

### worldmodel#
Contains the World supervisor class, and the parent classes for the objects that populate it: WorldObjs (objects in the world -- distinct from the singular World object), Subsystem (for specific, modifiable properties that WorldObjs can have, such as weapons or sensors) and the CommandableUnit interface.

#### worldmodel.subsystems #
Intended to hold different specific subsystems, each defined in a class.

### graphics #
Contains the graphics engine: Camera, which defines the renderer; Controller, which is the class unifying overall interface EventListeners and the UI state machine; MainGame, which initializes the overall game (at the specific world level at the moment -- i.e., not including a welcome/load/save menu, etc.); and MainGameTest, which is used as a prototype for testing purposes.

#### graphics.graphicsobjects #
Contains the classes for drawing specific graphics objects, such as shapes and sprites. These also interface with the underlying WorldObjs.

##Future Work #
Specific game logic will be implemented via child-classes of World. Potential elements to include are active/passive sensors, gravity, and constrained acceleration.

The next milestone will be implementing a small, functional mission: a Snark Hunt, involving hunting down and defeating very stupid computer-controlled enemies. 
