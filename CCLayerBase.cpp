#include "%FILE%.h"

%FILE%::%FILE%()
{
	
}
%FILE%::~%FILE%()
{
}
//void %FILE%::registerWithTouchDispatcher()
//{
//	CCTouchDispatcher::sharedDispatcher()->addTargetedDelegate(this, 0, false);
//}

//bool %FILE%::ccTouchBegan(CCTouch* pTouch, CCEvent* pEvent)
//{
//	CCTouch* touch = pTouch;
//
//	CCPoint location(ccp(0, 0));
//	location = CCDirector::sharedDirector()->convertToGL(touch->locationInView());
//
//	return true;
//}

bool %FILE%::init()
{
	CCLayer::init();
	
	return true;
}


