# Doudizhu
## Overview
This project is an implementation of a popular Chinese card game: Doudizhu. The game features easy-to-learn rules that are hard to master, requiring mathematical and strategic thinking as well as carefully planned execution.  
The game is played among three people with one pack of cards (54 count), including the two differentiated jokers. It starts with each player bidding for the "landlord" position. Those who lose the bid or do not bid enter the game as the "peasants" team competing against the landlord. For each player, the objective of the game is to be the first one to have no cards left.  
The game starts with the landlord. In each round, each player must be able to show a deck of a certain pattern following that of the last player in turn, while each card must be larger than each of the last player's. A player with no available cards to show will be skipped in the round. If both 2 other players are skipped for a pattern shown by a player, the game enters another round starting with that player.
## Logistics
* Application: main program 主程序，负责客户端服务器通信和逻辑
* Card: ADT of a card 卡牌ADT
* CardPanel: JPanel for showing a deck of cards, used for presenting current deck and player's own deck 卡牌展示框，展示当前一轮打出的牌组/玩家自己手上的的牌组
* CardView: JButton for visualization of a card 卡牌作为JButton展示
* Client: class for server 客户端
* ControlToolBar: JToolBar for sending cards/skipping 控制栏，负责发送发牌/要不起请求
* Deck: ADT of a card deck 牌组
* MainBody: main UI 主用户界面
* Message: ADT of a serializable message for server-client communication 信息ADT，可序列化
* OpponentStatusBar: JPanel of two OpponentStatusPanel 展示对方两个玩家的剩余牌数
* OpponentStatusPanel: JPanel of an opponent's status 展示一个对方玩家的剩余牌数
* Player: ADT of a player 玩家ADT
* Server: class of server 服务器
* StartPanel: JPanel for starting/connecting a server 开始页面选择client或server模式
