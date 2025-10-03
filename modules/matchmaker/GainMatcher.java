package com.vulpuslabs.matchmaker;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import java.util.function.DoubleSupplier;
import java.util.function.DoubleConsumer;


//[/user-imports]


public class MatchMaker extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

@SuppressWarnings("this-escape") 
public MatchMaker( long moduleID, VoltageObjects voltageObjects )
{
   super( moduleID, voltageObjects, "MatchMaker", ModuleType.ModuleType_Effect, 1.4 );

   InitializeControls();


   canBeBypassed = false;
   SetSkin( "1eb102a12353462c91a4c46e7320b520" );
}

void InitializeControls()
{

   textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "OUT" );
   AddComponent( textLabel15 );
   textLabel15.SetWantsMouseNotifications( false );
   textLabel15.SetPosition( 0, 311 );
   textLabel15.SetSize( 100, 15 );
   textLabel15.SetEditable( false, false );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel15.SetBkColor( new Color( 80, 32, 0, 255 ) );
   textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel15.SetBorderSize( 1 );
   textLabel15.SetMultiLineEdit( false );
   textLabel15.SetIsNumberEditor( false );
   textLabel15.SetNumberEditorRange( 0, 100 );
   textLabel15.SetNumberEditorInterval( 1 );
   textLabel15.SetNumberEditorUsesMouseWheel( false );
   textLabel15.SetHasCustomTextHoverColor( false );
   textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel15.SetFont( "Arial", 10, true, false );

   textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "RETURN" );
   AddComponent( textLabel11 );
   textLabel11.SetWantsMouseNotifications( false );
   textLabel11.SetPosition( 1, 269 );
   textLabel11.SetSize( 98, 15 );
   textLabel11.SetEditable( false, false );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel11.SetBkColor( new Color( 80, 32, 0, 255 ) );
   textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel11.SetBorderSize( 1 );
   textLabel11.SetMultiLineEdit( false );
   textLabel11.SetIsNumberEditor( false );
   textLabel11.SetNumberEditorRange( 0, 100 );
   textLabel11.SetNumberEditorInterval( 1 );
   textLabel11.SetNumberEditorUsesMouseWheel( false );
   textLabel11.SetHasCustomTextHoverColor( false );
   textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel11.SetFont( "Arial", 10, true, false );

   textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "IN" );
   AddComponent( textLabel14 );
   textLabel14.SetWantsMouseNotifications( false );
   textLabel14.SetPosition( 0, 37 );
   textLabel14.SetSize( 100, 15 );
   textLabel14.SetEditable( false, false );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel14.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel14.SetBkColor( new Color( 80, 32, 0, 255 ) );
   textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel14.SetBorderSize( 1 );
   textLabel14.SetMultiLineEdit( false );
   textLabel14.SetIsNumberEditor( false );
   textLabel14.SetNumberEditorRange( 0, 100 );
   textLabel14.SetNumberEditorInterval( 1 );
   textLabel14.SetNumberEditorUsesMouseWheel( false );
   textLabel14.SetHasCustomTextHoverColor( false );
   textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel14.SetFont( "Arial", 10, true, false );

   textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "SEND" );
   AddComponent( textLabel10 );
   textLabel10.SetWantsMouseNotifications( false );
   textLabel10.SetPosition( 1, 197 );
   textLabel10.SetSize( 98, 15 );
   textLabel10.SetEditable( false, false );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel10.SetBkColor( new Color( 80, 32, 0, 255 ) );
   textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel10.SetBorderSize( 1 );
   textLabel10.SetMultiLineEdit( false );
   textLabel10.SetIsNumberEditor( false );
   textLabel10.SetNumberEditorRange( 0, 100 );
   textLabel10.SetNumberEditorInterval( 1 );
   textLabel10.SetNumberEditorUsesMouseWheel( false );
   textLabel10.SetHasCustomTextHoverColor( false );
   textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel10.SetFont( "Arial", 10, true, false );

   leftInputJack = new VoltageAudioJack( "leftInputJack", "Left Input", this, JackType.JackType_AudioInput );
   AddComponent( leftInputJack );
   leftInputJack.SetWantsMouseNotifications( true );
   leftInputJack.SetPosition( 4, 31 );
   leftInputJack.SetSize( 25, 25 );
   leftInputJack.SetSkin( "Mini Jack 25px" );

   leftOutputJack = new VoltageAudioJack( "leftOutputJack", "Left Output", this, JackType.JackType_AudioOutput );
   AddComponent( leftOutputJack );
   leftOutputJack.SetWantsMouseNotifications( false );
   leftOutputJack.SetPosition( 4, 306 );
   leftOutputJack.SetSize( 25, 25 );
   leftOutputJack.SetSkin( "Mini Jack 25px" );

   leftSendJack = new VoltageAudioJack( "leftSendJack", "Left Send", this, JackType.JackType_AudioOutput );
   AddComponent( leftSendJack );
   leftSendJack.SetWantsMouseNotifications( false );
   leftSendJack.SetPosition( 4, 191 );
   leftSendJack.SetSize( 25, 25 );
   leftSendJack.SetSkin( "Mini Jack 25px" );

   leftReturnJack = new VoltageAudioJack( "leftReturnJack", "Left Return", this, JackType.JackType_AudioInput );
   AddComponent( leftReturnJack );
   leftReturnJack.SetWantsMouseNotifications( false );
   leftReturnJack.SetPosition( 4, 264 );
   leftReturnJack.SetSize( 25, 25 );
   leftReturnJack.SetSkin( "Mini Jack 25px" );

   rightInputJack = new VoltageAudioJack( "rightInputJack", "Right Input", this, JackType.JackType_AudioInput );
   AddComponent( rightInputJack );
   rightInputJack.SetWantsMouseNotifications( false );
   rightInputJack.SetPosition( 71, 32 );
   rightInputJack.SetSize( 25, 25 );
   rightInputJack.SetSkin( "Mini Jack 25px" );

   rightOutputJack = new VoltageAudioJack( "rightOutputJack", "Right Output", this, JackType.JackType_AudioOutput );
   AddComponent( rightOutputJack );
   rightOutputJack.SetWantsMouseNotifications( false );
   rightOutputJack.SetPosition( 71, 307 );
   rightOutputJack.SetSize( 25, 25 );
   rightOutputJack.SetSkin( "Mini Jack 25px" );

   rightSendJack = new VoltageAudioJack( "rightSendJack", "Right Send", this, JackType.JackType_AudioOutput );
   AddComponent( rightSendJack );
   rightSendJack.SetWantsMouseNotifications( false );
   rightSendJack.SetPosition( 71, 191 );
   rightSendJack.SetSize( 25, 25 );
   rightSendJack.SetSkin( "Mini Jack 25px" );

   rightReturnJack = new VoltageAudioJack( "rightReturnJack", "Right Return", this, JackType.JackType_AudioInput );
   AddComponent( rightReturnJack );
   rightReturnJack.SetWantsMouseNotifications( false );
   rightReturnJack.SetPosition( 71, 263 );
   rightReturnJack.SetSize( 25, 25 );
   rightReturnJack.SetSkin( "Mini Jack 25px" );

   attackKnob = new VoltageKnob( "attackKnob", "Attack", this, 1, 50, 5 );
   AddComponent( attackKnob );
   attackKnob.SetWantsMouseNotifications( false );
   attackKnob.SetPosition( 8, 65 );
   attackKnob.SetSize( 27, 27 );
   attackKnob.SetSkin( "JP-106 Gray" );
   attackKnob.SetRange( 1, 50, 5, false, 0 );
   attackKnob.SetKnobParams( 215, 145 );
   attackKnob.SetUnits( "ms" );
   attackKnob.DisplayValueInPercent( false );
   attackKnob.SetKnobAdjustsRing( true );

   releaseKnob = new VoltageKnob( "releaseKnob", "Release", this, 1, 50, 5 );
   AddComponent( releaseKnob );
   releaseKnob.SetWantsMouseNotifications( false );
   releaseKnob.SetPosition( 8, 101 );
   releaseKnob.SetSize( 27, 27 );
   releaseKnob.SetSkin( "JP-106 Gray" );
   releaseKnob.SetRange( 1, 50, 5, false, 0 );
   releaseKnob.SetKnobParams( 215, 145 );
   releaseKnob.SetUnits( "ms" );
   releaseKnob.DisplayValueInPercent( false );
   releaseKnob.SetKnobAdjustsRing( true );

   sendGainKnob = new VoltageKnob( "sendGainKnob", "Send Gain", this, -24, 24, 0 );
   AddComponent( sendGainKnob );
   sendGainKnob.SetWantsMouseNotifications( false );
   sendGainKnob.SetPosition( 8, 155 );
   sendGainKnob.SetSize( 27, 27 );
   sendGainKnob.SetSkin( "JP-106 Gray" );
   sendGainKnob.SetRange( -24, 24, 0, false, 0 );
   sendGainKnob.SetKnobParams( 215, 145 );
   sendGainKnob.SetUnits( "dB" );
   sendGainKnob.DisplayValueInPercent( false );
   sendGainKnob.SetKnobAdjustsRing( true );

   effectMixKnob = new VoltageKnob( "effectMixKnob", "Effect Mix", this, 0, 1, 1 );
   AddComponent( effectMixKnob );
   effectMixKnob.SetWantsMouseNotifications( false );
   effectMixKnob.SetPosition( 8, 228 );
   effectMixKnob.SetSize( 27, 27 );
   effectMixKnob.SetSkin( "JP-106 Gray" );
   effectMixKnob.SetRange( 0, 1, 1, false, 0 );
   effectMixKnob.SetKnobParams( 215, 145 );
   effectMixKnob.DisplayValueInPercent( true );
   effectMixKnob.SetKnobAdjustsRing( true );

   textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "VULPUS LABS" );
   AddComponent( textLabel1 );
   textLabel1.SetWantsMouseNotifications( false );
   textLabel1.SetPosition( 0, 345 );
   textLabel1.SetSize( 100, 15 );
   textLabel1.SetEditable( false, false );
   textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel1.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel1.SetBorderSize( 1 );
   textLabel1.SetMultiLineEdit( false );
   textLabel1.SetIsNumberEditor( false );
   textLabel1.SetNumberEditorRange( 0, 100 );
   textLabel1.SetNumberEditorInterval( 1 );
   textLabel1.SetNumberEditorUsesMouseWheel( false );
   textLabel1.SetHasCustomTextHoverColor( false );
   textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel1.SetFont( "Arial", 10, true, false );

   textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "ATTACK" );
   AddComponent( textLabel2 );
   textLabel2.SetWantsMouseNotifications( false );
   textLabel2.SetPosition( 38, 69 );
   textLabel2.SetSize( 62, 15 );
   textLabel2.SetEditable( false, false );
   textLabel2.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel2.SetBorderSize( 1 );
   textLabel2.SetMultiLineEdit( false );
   textLabel2.SetIsNumberEditor( false );
   textLabel2.SetNumberEditorRange( 0, 100 );
   textLabel2.SetNumberEditorInterval( 1 );
   textLabel2.SetNumberEditorUsesMouseWheel( false );
   textLabel2.SetHasCustomTextHoverColor( false );
   textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel2.SetFont( "Arial", 10, true, false );

   textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "RELEASE" );
   AddComponent( textLabel3 );
   textLabel3.SetWantsMouseNotifications( false );
   textLabel3.SetPosition( 38, 105 );
   textLabel3.SetSize( 62, 15 );
   textLabel3.SetEditable( false, false );
   textLabel3.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel3.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel3.SetBorderSize( 1 );
   textLabel3.SetMultiLineEdit( false );
   textLabel3.SetIsNumberEditor( false );
   textLabel3.SetNumberEditorRange( 0, 100 );
   textLabel3.SetNumberEditorInterval( 1 );
   textLabel3.SetNumberEditorUsesMouseWheel( false );
   textLabel3.SetHasCustomTextHoverColor( false );
   textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel3.SetFont( "Arial", 10, true, false );

   textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "SEND GAIN" );
   AddComponent( textLabel4 );
   textLabel4.SetWantsMouseNotifications( false );
   textLabel4.SetPosition( 38, 159 );
   textLabel4.SetSize( 62, 15 );
   textLabel4.SetEditable( false, false );
   textLabel4.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel4.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel4.SetBorderSize( 1 );
   textLabel4.SetMultiLineEdit( false );
   textLabel4.SetIsNumberEditor( false );
   textLabel4.SetNumberEditorRange( 0, 100 );
   textLabel4.SetNumberEditorInterval( 1 );
   textLabel4.SetNumberEditorUsesMouseWheel( false );
   textLabel4.SetHasCustomTextHoverColor( false );
   textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel4.SetFont( "Arial", 10, true, false );

   textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "EFFECT MIX" );
   AddComponent( textLabel5 );
   textLabel5.SetWantsMouseNotifications( false );
   textLabel5.SetPosition( 38, 233 );
   textLabel5.SetSize( 62, 15 );
   textLabel5.SetEditable( false, false );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel5.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel5.SetBorderSize( 1 );
   textLabel5.SetMultiLineEdit( false );
   textLabel5.SetIsNumberEditor( false );
   textLabel5.SetNumberEditorRange( 0, 100 );
   textLabel5.SetNumberEditorInterval( 1 );
   textLabel5.SetNumberEditorUsesMouseWheel( false );
   textLabel5.SetHasCustomTextHoverColor( false );
   textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel5.SetFont( "Arial", 10, true, false );

   textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "MATCHMAKER" );
   AddComponent( textLabel7 );
   textLabel7.SetWantsMouseNotifications( false );
   textLabel7.SetPosition( 0, 0 );
   textLabel7.SetSize( 100, 15 );
   textLabel7.SetEditable( false, false );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel7.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel7.SetBorderSize( 1 );
   textLabel7.SetMultiLineEdit( false );
   textLabel7.SetIsNumberEditor( false );
   textLabel7.SetNumberEditorRange( 0, 100 );
   textLabel7.SetNumberEditorInterval( 1 );
   textLabel7.SetNumberEditorUsesMouseWheel( false );
   textLabel7.SetHasCustomTextHoverColor( false );
   textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel7.SetFont( "Arial", 10, true, false );

   textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "EFFECT LOOP" );
   AddComponent( textLabel8 );
   textLabel8.SetWantsMouseNotifications( false );
   textLabel8.SetPosition( 0, 137 );
   textLabel8.SetSize( 100, 15 );
   textLabel8.SetEditable( false, false );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel8.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel8.SetBorderSize( 1 );
   textLabel8.SetMultiLineEdit( false );
   textLabel8.SetIsNumberEditor( false );
   textLabel8.SetNumberEditorRange( 0, 100 );
   textLabel8.SetNumberEditorInterval( 1 );
   textLabel8.SetNumberEditorUsesMouseWheel( false );
   textLabel8.SetHasCustomTextHoverColor( false );
   textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel8.SetFont( "Arial", 10, true, false );

   textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "L" );
   AddComponent( textLabel12 );
   textLabel12.SetWantsMouseNotifications( false );
   textLabel12.SetPosition( 0, 15 );
   textLabel12.SetSize( 33, 15 );
   textLabel12.SetEditable( false, false );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel12.SetBorderSize( 1 );
   textLabel12.SetMultiLineEdit( false );
   textLabel12.SetIsNumberEditor( false );
   textLabel12.SetNumberEditorRange( 0, 100 );
   textLabel12.SetNumberEditorInterval( 1 );
   textLabel12.SetNumberEditorUsesMouseWheel( false );
   textLabel12.SetHasCustomTextHoverColor( false );
   textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel12.SetFont( "Arial", 10, true, true );

   textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "R" );
   AddComponent( textLabel13 );
   textLabel13.SetWantsMouseNotifications( false );
   textLabel13.SetPosition( 67, 15 );
   textLabel13.SetSize( 33, 15 );
   textLabel13.SetEditable( false, false );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel13.SetBorderSize( 1 );
   textLabel13.SetMultiLineEdit( false );
   textLabel13.SetIsNumberEditor( false );
   textLabel13.SetNumberEditorRange( 0, 100 );
   textLabel13.SetNumberEditorInterval( 1 );
   textLabel13.SetNumberEditorUsesMouseWheel( false );
   textLabel13.SetHasCustomTextHoverColor( false );
   textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel13.SetFont( "Arial", 10, true, true );
}



//-------------------------------------------------------------------------------
//  public void Initialize()

//  Initialize will get called shortly after your module's constructor runs. You can use it to
//  do any initialization that the auto-generated code doesn't handle.
//-------------------------------------------------------------------------------
@Override
public void Initialize()
{
   //[user-Initialize]   Add your own initialization code here
   leftCircuit = new GainMatchedCircuit(
      leftReturnJack::GetValue,
      leftSendJack::SetValue
   );
   
   rightCircuit = new GainMatchedCircuit(
      rightReturnJack::GetValue,
      rightSendJack::SetValue
   );


   //[/user-Initialize]
}


//-------------------------------------------------------------------------------
//  public void Destroy()

//  Destroy will get called just before your module gets deleted. You can use it to perform any
//  cleanup that's not handled automatically by Java.
//-------------------------------------------------------------------------------
@Override
public void Destroy()
{
   super.Destroy();
   //[user-Destroy]   Add your own module-getting-deleted code here



   //[/user-Destroy]
}


//-------------------------------------------------------------------------------
//  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

//  Notify will get called when various events occur - control values changing, timers firing, etc.
//-------------------------------------------------------------------------------
@Override
public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
{
   //[user-Notify]   Add your own notification handling code between this line and the notify-close comment
   switch( notification )
   {
      case Knob_Changed:   // doubleValue is the new VoltageKnob value
      {
         if (component == attackKnob) {
            setAttack(doubleValue);
         }
         if (component == releaseKnob) {
            setRelease(doubleValue);
         }
         if (component == sendGainKnob) {
            setSendGainDb(doubleValue);
         }
         if (component == effectMixKnob) {
            setEffectMix(doubleValue);
         }
      }
      break;
   
      case Slider_Changed:   // doubleValue is the new slider value
      {
      }
      break;
   
      case Button_Changed:   // doubleValue is the new button/toggle button value
      {
      }
      break;
   
      case Switch_Changed:   // doubleValue is the new switch value
      {
      }
      break;
   
      case Jack_Connected:   // longValue is the new cable ID
      {
         updateActive();
      }
      break;
   
      case Jack_Disconnected:   // All cables have been disconnected from this jack
      {
         updateActive();
      }
      break;
   
      case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
      {
      }
      break;
   
      case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
      {
      }
      break;
   
      case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
      {
      }
      break;
   
      case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
      {
      }
      break;
   
      // Less common notifications:
   
      case Named_Timer:   // object contains a String with the name of the timer that has fired
      {
      }
      break;
   
      case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
      {
      }
      break;
   
      case Canvas_Painted:   // Canvas painting is complete
      {
      }
      break;
   
      case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
      {
      }
      break;
   
      case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
      {
      }
      break;
   
      case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
      {
      }
      break;
   
      case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
      {
      }
      break;
   
      case Label_Changed:        // The text of an editable text control has changed
      {
      }
      break;
   
      case SoundPlayback_Start:   // A sound has begun playback
      {
      }
      break;
   
      case SoundPlayback_End:     // A sound has ended playback
      {
      }
      break;
   
      case Scrollbar_Position:    // longValue is the new scrollbar position
      {
      }
      break;
   
      case PolyVoices_Changed:    // longValue is the new number of poly voices
      {
      }
      break;
   
      case File_Dropped:     // 'object' is a String containing the file path
      {
      }
      break;
   
      case Preset_Loading_Start:   // called when preset loading begins
      {
      }
      break;
   
      case Preset_Loading_Finish:  // called when preset loading finishes
      {
      }
      break;
   
      case Variation_Loading_Start:    // sent when a variation is about to load
      {
      }
      break;
   
      case Variation_Loading_Finish:   // sent when a variation has just finished loading
      {
      }
      break;
   
      case Tempo_Changed:     // doubleValue is the new tempo
      {
      }
      break;
   
      case Randomized:     // called when the module's controls get randomized
      {
      }
      break;
   
      case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
      {
      }
      break;
   
      case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
      {
      }
      break;
   
      case Reset:    // sent when the module has been reset to default settings
      {
      }
      break;
   
      case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
      {
      }
      break;
   
      case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
      {
      }
      break;
   
      case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
      {
      }
      break;
   }



   return false;
   //[/user-Notify]
}


//-------------------------------------------------------------------------------
//  public void ProcessSample()

//  ProcessSample is called once per sample. Usually it's where you read
//  from input jacks, process audio, and write it to your output jacks.
//  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
//  to other threads when possible and avoid calling native functions.
//-------------------------------------------------------------------------------
@Override
public void ProcessSample()
{
   //[user-ProcessSample]   Add your own process-sampling code here
   double leftIn = leftInputJack.GetValue();
   double leftOut = leftCircuit.processSample(leftIn);
   
   double rightIn = copyInputToRight ? leftIn : rightInputJack.GetValue();
   double rightOut = copyOutputToRight ? leftOut : rightCircuit.processSample(rightIn);
   
   leftOutputJack.SetValue(leftOut);
   rightOutputJack.SetValue(rightOut);
   //[/user-ProcessSample]
}


//-------------------------------------------------------------------------------
//  public String GetTooltipText( VoltageComponent component )

//  Gets called when a tooltip is about to display for a control. Override it if
//  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
//  for instance, you can translate the knob's current value to a log-based string and display it here.
//-------------------------------------------------------------------------------
@Override
public String GetTooltipText( VoltageComponent component )
{
   //[user-GetTooltipText]   Add your own code here



   return super.GetTooltipText( component );
   //[/user-GetTooltipText]
}


//-------------------------------------------------------------------------------
//  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

//  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
//  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
//  in GetTooltipText().
//-------------------------------------------------------------------------------
@Override
public void EditComponentValue( VoltageComponent component, double newValue, String newText )
{
   //[user-EditComponentValue]   Add your own code here



   //[/user-EditComponentValue]
   super.EditComponentValue( component, newValue, newText );
}


//-------------------------------------------------------------------------------
//  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

//  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
//  process them in this function when they get triggered by undo/redo actions.
//-------------------------------------------------------------------------------
@Override
public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
{
   //[user-OnUndoRedo]   Add your own code here



   //[/user-OnUndoRedo]
}


//-------------------------------------------------------------------------------
//  public byte[] GetStateInformation()

//  Gets called when the module's state gets saved, typically when the user saves a preset with
//  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
//  but if you have any custom state information you need to save, return it from this function.
//-------------------------------------------------------------------------------
@Override
public byte[] GetStateInformation()
{
   //[user-GetStateInformation]   Add your own code here



   return null;
   //[/user-GetStateInformation]
}


//-------------------------------------------------------------------------------
//  public void SetStateInformation(byte[] stateInfo)

//  Gets called when this module's state is getting restored, typically when a user opens a preset with
//  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
//-------------------------------------------------------------------------------
@Override
public void SetStateInformation(byte[] stateInfo)
{
   //[user-SetStateInformation]   Add your own code here



   //[/user-SetStateInformation]
}


//-------------------------------------------------------------------------------
//  public byte[] GetStateInformationForVariations()

//  Gets called when a user saves a variation with this module in it.
//  Voltage Modular will automatically save the states of knobs, sliders, etc.,
//  but if you have any custom state information you need to save, return it from this function.
//-------------------------------------------------------------------------------
@Override
public byte[] GetStateInformationForVariations()
{
   //[user-GetStateInformationForVariations]   Add your own code here



   return GetStateInformation();
   //[/user-GetStateInformationForVariations]
}


//-------------------------------------------------------------------------------
//  public void SetStateInformationForVariations(byte[] stateInfo)

//  Gets called when a user loads a variation with this module in it.
//  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
//-------------------------------------------------------------------------------
@Override
public void SetStateInformationForVariations(byte[] stateInfo)
{
   //[user-SetStateInformationForVariations]   Add your own code here
   SetStateInformation(stateInfo);



   //[/user-SetStateInformationForVariations]
}


// Auto-generated variables
private VoltageLabel textLabel13;
private VoltageLabel textLabel12;
private VoltageLabel textLabel8;
private VoltageLabel textLabel7;
private VoltageLabel textLabel5;
private VoltageLabel textLabel4;
private VoltageLabel textLabel3;
private VoltageLabel textLabel2;
private VoltageLabel textLabel1;
private VoltageKnob effectMixKnob;
private VoltageKnob sendGainKnob;
private VoltageKnob releaseKnob;
private VoltageKnob attackKnob;
private VoltageAudioJack rightReturnJack;
private VoltageAudioJack rightSendJack;
private VoltageAudioJack rightOutputJack;
private VoltageAudioJack rightInputJack;
private VoltageAudioJack leftReturnJack;
private VoltageAudioJack leftSendJack;
private VoltageAudioJack leftOutputJack;
private VoltageAudioJack leftInputJack;
private VoltageLabel textLabel10;
private VoltageLabel textLabel14;
private VoltageLabel textLabel11;
private VoltageLabel textLabel15;


//[user-code-and-variables]    Add your own variables and functions here
private GainMatchedCircuit leftCircuit;
private GainMatchedCircuit rightCircuit;
private boolean copyInputToRight;
private boolean copyOutputToRight;

private void updateActive() {
   copyInputToRight = !rightInputJack.IsConnected();
   
   boolean rightCircuitIsActive = rightInputJack.IsConnected() ||
      rightSendJack.IsConnected() ||
      rightReturnJack.IsConnected();
      
   copyOutputToRight = rightOutputJack.IsConnected() && !rightCircuitIsActive;
}

private static class GainMatchedCircuit {
 
    private static final int SAMPLE_RATE = 48000;

    private static double getAlpha(double durationMs) {
        double durationInSamples = (durationMs / 1000.0) * SAMPLE_RATE;
        return Math.exp(-1.0 / durationInSamples);
    }
    
    private static final double PEAK_ALPHA = getAlpha(10.0);
    private static final double ONE_MINUS_PEAK_ALPHA = 1.0 - PEAK_ALPHA;
    private static final double THRESHOLD = 0.05;
    
    private final DoubleSupplier returnSupplier;
    private final DoubleConsumer sendConsumer;
    
    private final GainMatcher matcher = new GainMatcher(SAMPLE_RATE);
    
    private double sendGainTarget;
    private double sendGain;
    private double effectMix;
    private double oneMinusEffectMix;
    
    public GainMatchedCircuit(
       DoubleSupplier returnSupplier,
       DoubleConsumer sendConsumer) {
       this.returnSupplier = returnSupplier;
       this.sendConsumer = sendConsumer;
    }
    
    public void setSendGainDb(double sendGainDb) {
       this.sendGainTarget = Math.pow(10, sendGainDb / 20.0);
    }
    
    public void setEffectMix(double effectPercentage) {
       effectMix = effectPercentage;
       oneMinusEffectMix = 1.0 - effectMix;
    }
    
    public void setAttack(double attackMs) {
       matcher.setAttackMs(attackMs);
    }
    
    public void setRelease(double releaseMs) {
       matcher.setReleaseMs(releaseMs);
    }
    
    public double processSample(double inSample) {
       double returnSample = returnSupplier.getAsDouble();
       
       sendGain = (0.01 * sendGainTarget) + (0.99 * sendGain);
       double sendSample = inSample * sendGain;
       
       double mixedReturnSample = effectMix * returnSample + oneMinusEffectMix * sendSample;
       double outSample = matcher.processSample(inSample, mixedReturnSample);
       
       sendConsumer.accept(sendSample);
       return outSample;
    }
    
}

private static class GainMatcher {

    private static final double THRESHOLD = 0.001;
    
    private final ExponentialDecayMS inMs;
    private final ExponentialDecayMS outMs;

    public GainMatcher(int sampleRate) {
       inMs = new ExponentialDecayMS(sampleRate);
       outMs = new ExponentialDecayMS(sampleRate);
    }
    
    public void setAttackMs(double attackMs) {
       inMs.setAttackMs(attackMs);
       outMs.setAttackMs(attackMs);
   }
   
   public void setReleaseMs(double releaseMs) {
       inMs.setReleaseMs(releaseMs);
       outMs.setReleaseMs(releaseMs);
   }
    
    public double processSample(double sendSample, double returnSample) {
       double sendMs = inMs.processSample(sendSample);
       double returnMs = Math.max(THRESHOLD, outMs.processSample(returnSample));

       double gainMatched = returnSample * Math.sqrt(sendMs / returnMs);
       return gainMatched;
    }
}

private static class ExponentialDecayMS {
    private final int sampleRate;
    private double attackAlpha;
    private double releaseAlpha;
    private double meanSquare;
    
    /**
     * Creates an exponentially decaying RMS calculator
     * @param sampleRate Sample rate in Hz (e.g., 48000)
     * @param decayTimeMs Decay time in milliseconds (e.g., 10.0)
     */
    public ExponentialDecayMS(int sampleRate) {
        this.sampleRate = sampleRate;
        this.meanSquare = 0.0;
    }
    
    public void setAttackMs(double attackMs) {
        double attackTimeInSamples = (attackMs / 1000.0) * sampleRate;
        this.attackAlpha = Math.exp(-1.0 / attackTimeInSamples);
    }
    
    public void setReleaseMs(double releaseMs) {
        double releaseTimeInSamples = (releaseMs / 1000.0) * sampleRate;
        this.releaseAlpha = Math.exp(-1.0 / releaseTimeInSamples);
    }
    
    /**
     * Process a single audio sample and update the RMS value
     * @param sample Input audio sample
     * @return Current RMS value
     */
    public double processSample(double sample) {
        double squaredSample = sample * sample;
        
        meanSquare = squaredSample > meanSquare
           ? attackAlpha * meanSquare + (1.0 - attackAlpha) * squaredSample
           : releaseAlpha * meanSquare + (1.0 - releaseAlpha) * squaredSample;
        
        return meanSquare;
    }
}

private void setAttack(double attackMs) {
   leftCircuit.setAttack(attackMs);
   rightCircuit.setAttack(attackMs);
}

private void setRelease(double releaseMs) {
   leftCircuit.setRelease(releaseMs);
   rightCircuit.setRelease(releaseMs);
}

private void setSendGainDb(double sendGainDb) {
   leftCircuit.setSendGainDb(sendGainDb);
   rightCircuit.setSendGainDb(sendGainDb);
}

private void setEffectMix(double effectMix) {
   leftCircuit.setEffectMix(effectMix);
   rightCircuit.setEffectMix(effectMix);
}


//[/user-code-and-variables]
}

 