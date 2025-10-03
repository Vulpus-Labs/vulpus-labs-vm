package com.vulpuslabs.magnus;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
//[/user-imports]


public class Magnus extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

@SuppressWarnings("this-escape") 
public Magnus( long moduleID, VoltageObjects voltageObjects )
{
   super( moduleID, voltageObjects, "Magnus", ModuleType.ModuleType_Utility, 1.4 );

   InitializeControls();


   canBeBypassed = false;
   SetSkin( "6afb45a1e33d44fb92bc75eed7f74985" );
}

void InitializeControls()
{

   rightInputJack = new VoltageAudioJack( "rightInputJack", "Right Input", this, JackType.JackType_AudioInput );
   AddComponent( rightInputJack );
   rightInputJack.SetWantsMouseNotifications( false );
   rightInputJack.SetPosition( 70, 24 );
   rightInputJack.SetSize( 25, 25 );
   rightInputJack.SetSkin( "Jack Round 25px" );

   leftInputJack = new VoltageAudioJack( "leftInputJack", "Left Input", this, JackType.JackType_AudioInput );
   AddComponent( leftInputJack );
   leftInputJack.SetWantsMouseNotifications( false );
   leftInputJack.SetPosition( 4, 24 );
   leftInputJack.SetSize( 25, 25 );
   leftInputJack.SetSkin( "Jack Round 25px" );

   attackKnob = new VoltageKnob( "attackKnob", "Attack", this, 0.5, 50, 5 );
   AddComponent( attackKnob );
   attackKnob.SetWantsMouseNotifications( false );
   attackKnob.SetPosition( 8, 64 );
   attackKnob.SetSize( 41, 41 );
   attackKnob.SetSkin( "Dial Lemon" );
   attackKnob.SetRange( 0.5, 50, 5, false, 0 );
   attackKnob.SetKnobParams( 215, 145 );
   attackKnob.SetUnits( "ms" );
   attackKnob.DisplayValueInPercent( false );
   attackKnob.SetKnobAdjustsRing( true );

   releaseKnob = new VoltageKnob( "releaseKnob", "Release", this, 20, 200, 50 );
   AddComponent( releaseKnob );
   releaseKnob.SetWantsMouseNotifications( false );
   releaseKnob.SetPosition( 8, 128 );
   releaseKnob.SetSize( 41, 41 );
   releaseKnob.SetSkin( "Dial Yellow" );
   releaseKnob.SetRange( 20, 200, 50, false, 0 );
   releaseKnob.SetKnobParams( 215, 145 );
   releaseKnob.SetUnits( "ms" );
   releaseKnob.DisplayValueInPercent( false );
   releaseKnob.SetKnobAdjustsRing( true );
   releaseKnob.SetMidpointValue( 50 );

   gateThresholdKnob = new VoltageKnob( "gateThresholdKnob", "Gate Threshold", this, -60, -12, -60 );
   AddComponent( gateThresholdKnob );
   gateThresholdKnob.SetWantsMouseNotifications( false );
   gateThresholdKnob.SetPosition( 8, 192 );
   gateThresholdKnob.SetSize( 41, 41 );
   gateThresholdKnob.SetSkin( "Dial Orange" );
   gateThresholdKnob.SetRange( -60, -12, -60, false, 0 );
   gateThresholdKnob.SetKnobParams( 215, 145 );
   gateThresholdKnob.SetUnits( "dBFS" );
   gateThresholdKnob.DisplayValueInPercent( false );
   gateThresholdKnob.SetKnobAdjustsRing( true );

   targetVolumeKnob = new VoltageKnob( "targetVolumeKnob", "Target Volume", this, -12, 0, -6 );
   AddComponent( targetVolumeKnob );
   targetVolumeKnob.SetWantsMouseNotifications( false );
   targetVolumeKnob.SetPosition( 8, 256 );
   targetVolumeKnob.SetSize( 41, 41 );
   targetVolumeKnob.SetSkin( "Dial Red" );
   targetVolumeKnob.SetRange( -12, 0, -6, false, 0 );
   targetVolumeKnob.SetKnobParams( 215, 145 );
   targetVolumeKnob.SetUnits( "dBFS" );
   targetVolumeKnob.DisplayValueInPercent( false );
   targetVolumeKnob.SetKnobAdjustsRing( true );

   leftOutputJack = new VoltageAudioJack( "leftOutputJack", "Left Output", this, JackType.JackType_AudioOutput );
   AddComponent( leftOutputJack );
   leftOutputJack.SetWantsMouseNotifications( false );
   leftOutputJack.SetPosition( 8, 315 );
   leftOutputJack.SetSize( 25, 25 );
   leftOutputJack.SetSkin( "Jack Round 25px" );

   rightOutputJack = new VoltageAudioJack( "rightOutputJack", "Right Output", this, JackType.JackType_AudioOutput );
   AddComponent( rightOutputJack );
   rightOutputJack.SetWantsMouseNotifications( false );
   rightOutputJack.SetPosition( 70, 315 );
   rightOutputJack.SetSize( 25, 25 );
   rightOutputJack.SetSkin( "Jack Round 25px" );

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
   textLabel1.SetFont( "Arial Black", 10, true, false );

   textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "MAGNUS" );
   AddComponent( textLabel2 );
   textLabel2.SetWantsMouseNotifications( false );
   textLabel2.SetPosition( 0, 0 );
   textLabel2.SetSize( 100, 15 );
   textLabel2.SetEditable( false, false );
   textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
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
   textLabel2.SetFont( "Arial Black", 10, true, false );

   textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "ATTACK" );
   AddComponent( textLabel3 );
   textLabel3.SetWantsMouseNotifications( false );
   textLabel3.SetPosition( 52, 76 );
   textLabel3.SetSize( 46, 15 );
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
   textLabel3.SetFont( "Arial Black", 10, true, false );

   textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "RELEASE" );
   AddComponent( textLabel4 );
   textLabel4.SetWantsMouseNotifications( false );
   textLabel4.SetPosition( 52, 140 );
   textLabel4.SetSize( 46, 15 );
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
   textLabel4.SetFont( "Arial Black", 10, true, false );

   textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "GATE" );
   AddComponent( textLabel5 );
   textLabel5.SetWantsMouseNotifications( false );
   textLabel5.SetPosition( 52, 204 );
   textLabel5.SetSize( 46, 15 );
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
   textLabel5.SetFont( "Arial Black", 10, true, false );

   textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "TARGET" );
   AddComponent( textLabel6 );
   textLabel6.SetWantsMouseNotifications( false );
   textLabel6.SetPosition( 52, 268 );
   textLabel6.SetSize( 46, 15 );
   textLabel6.SetEditable( false, false );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel6.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel6.SetBorderSize( 1 );
   textLabel6.SetMultiLineEdit( false );
   textLabel6.SetIsNumberEditor( false );
   textLabel6.SetNumberEditorRange( 0, 100 );
   textLabel6.SetNumberEditorInterval( 1 );
   textLabel6.SetNumberEditorUsesMouseWheel( false );
   textLabel6.SetHasCustomTextHoverColor( false );
   textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel6.SetFont( "Arial Black", 10, true, false );

   textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "L (M)" );
   AddComponent( textLabel7 );
   textLabel7.SetWantsMouseNotifications( false );
   textLabel7.SetPosition( 30, 32 );
   textLabel7.SetSize( 24, 12 );
   textLabel7.SetEditable( false, false );
   textLabel7.SetJustificationFlags( VoltageLabel.Justification.Left );
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
   textLabel7.SetFont( "Arial Black", 10, true, false );

   textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "R" );
   AddComponent( textLabel8 );
   textLabel8.SetWantsMouseNotifications( false );
   textLabel8.SetPosition( 51, 32 );
   textLabel8.SetSize( 16, 12 );
   textLabel8.SetEditable( false, false );
   textLabel8.SetJustificationFlags( VoltageLabel.Justification.Right );
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
   textLabel8.SetFont( "Arial Black", 10, true, false );

   textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "INPUT" );
   AddComponent( textLabel9 );
   textLabel9.SetWantsMouseNotifications( false );
   textLabel9.SetPosition( 0, 21 );
   textLabel9.SetSize( 100, 12 );
   textLabel9.SetEditable( false, false );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel9.SetBorderSize( 1 );
   textLabel9.SetMultiLineEdit( false );
   textLabel9.SetIsNumberEditor( false );
   textLabel9.SetNumberEditorRange( 0, 100 );
   textLabel9.SetNumberEditorInterval( 1 );
   textLabel9.SetNumberEditorUsesMouseWheel( false );
   textLabel9.SetHasCustomTextHoverColor( false );
   textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel9.SetFont( "Arial Black", 10, true, false );

   textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "OUTPUT" );
   AddComponent( textLabel10 );
   textLabel10.SetWantsMouseNotifications( false );
   textLabel10.SetPosition( 0, 314 );
   textLabel10.SetSize( 100, 12 );
   textLabel10.SetEditable( false, false );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel10.SetBorderSize( 1 );
   textLabel10.SetMultiLineEdit( false );
   textLabel10.SetIsNumberEditor( false );
   textLabel10.SetNumberEditorRange( 0, 100 );
   textLabel10.SetNumberEditorInterval( 1 );
   textLabel10.SetNumberEditorUsesMouseWheel( false );
   textLabel10.SetHasCustomTextHoverColor( false );
   textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel10.SetFont( "Arial Black", 10, true, false );

   textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "L" );
   AddComponent( textLabel11 );
   textLabel11.SetWantsMouseNotifications( false );
   textLabel11.SetPosition( 35, 325 );
   textLabel11.SetSize( 23, 12 );
   textLabel11.SetEditable( false, false );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.Left );
   textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel11.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel11.SetBorderSize( 1 );
   textLabel11.SetMultiLineEdit( false );
   textLabel11.SetIsNumberEditor( false );
   textLabel11.SetNumberEditorRange( 0, 100 );
   textLabel11.SetNumberEditorInterval( 1 );
   textLabel11.SetNumberEditorUsesMouseWheel( false );
   textLabel11.SetHasCustomTextHoverColor( false );
   textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel11.SetFont( "Arial Black", 10, true, false );

   textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "R" );
   AddComponent( textLabel12 );
   textLabel12.SetWantsMouseNotifications( false );
   textLabel12.SetPosition( 53, 325 );
   textLabel12.SetSize( 16, 12 );
   textLabel12.SetEditable( false, false );
   textLabel12.SetJustificationFlags( VoltageLabel.Justification.Right );
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
   textLabel12.SetFont( "Arial Black", 10, true, false );
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
         if (component == attackKnob) setAttackMs(doubleValue);
         if (component == releaseKnob) setReleaseMs(doubleValue);
         if (component == gateThresholdKnob) setGateThresholdDbfs(doubleValue);
         if (component == targetVolumeKnob) setTargetDbfs(doubleValue);
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
         if (component == leftInputJack) leftIsConnected = true;
         if (component == rightInputJack) rightIsConnected = true;
      }
      break;
   
      case Jack_Disconnected:   // All cables have been disconnected from this jack
      {
         if (component == leftInputJack) leftIsConnected = false;
         if (component == rightInputJack) rightIsConnected = false;
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
   double rightIn = rightIsConnected ? rightInputJack.GetValue() : leftIn;
   
   double leftOut = left.processSample(leftIn * 0.2);
   double rightOut = rightIsConnected
      ? right.processSample(rightIn * 0.2)
      : leftOut;
   
   leftOutputJack.SetValue(leftOut * 5.0);
   rightOutputJack.SetValue(rightOut * 5.0);
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
private VoltageLabel textLabel12;
private VoltageLabel textLabel11;
private VoltageLabel textLabel10;
private VoltageLabel textLabel9;
private VoltageLabel textLabel8;
private VoltageLabel textLabel7;
private VoltageLabel textLabel6;
private VoltageLabel textLabel5;
private VoltageLabel textLabel4;
private VoltageLabel textLabel3;
private VoltageLabel textLabel2;
private VoltageLabel textLabel1;
private VoltageAudioJack rightOutputJack;
private VoltageAudioJack leftOutputJack;
private VoltageKnob targetVolumeKnob;
private VoltageKnob gateThresholdKnob;
private VoltageKnob releaseKnob;
private VoltageKnob attackKnob;
private VoltageAudioJack leftInputJack;
private VoltageAudioJack rightInputJack;


//[user-code-and-variables]    Add your own variables and functions here
private final Maximiser left = new Maximiser();
private final Maximiser right = new Maximiser();
private boolean leftIsConnected;
private boolean rightIsConnected;

private void setAttackMs(double attackMs) {
   left.setAttackMs(attackMs);
   right.setAttackMs(attackMs);
}

private void setReleaseMs(double releaseMs) {
   left.setReleaseMs(releaseMs);
   right.setReleaseMs(releaseMs);
}

private void setGateThresholdDbfs(double gateThresholdDbfs) {
   left.setGateThresholdDbfs(gateThresholdDbfs);
   right.setGateThresholdDbfs(gateThresholdDbfs);
}

private void setTargetDbfs(double targetDbfs) {
   left.setTargetDbfs(targetDbfs);
   right.setTargetDbfs(targetDbfs);
}

private static final class Maximiser {

   private static final double PEAK_THRESHOLD = Math.pow(10, -1.0 / 20.0);
   private static final double PEAK_RANGE = 1.0 - PEAK_THRESHOLD;
   private static final double PEAK_RANGE_RECIPROCAL = 1.0 / PEAK_RANGE;
   private static final double PEAK_RANGE_SCALING = 1.0 / PEAK_RANGE;
   
   private double attackAlpha;
   private double releaseAlpha;
   private double gateThresholdDbfs;
   private double gateTransitionDbfs;
   private double targetDbfs;
   private double meanSquare;
   private double rangeReciprocal;

   public void setGateThresholdDbfs(double gateThresholdDbfs) {
      this.gateThresholdDbfs = gateThresholdDbfs;
      this.gateTransitionDbfs = gateThresholdDbfs - 10.0;
      this.rangeReciprocal = 0.1;
   }
   
   private static double alpha(double timeMs) {
      return 1.0 - Math.exp(-1.0 / (timeMs * 48.0));
   }
   
   public void setAttackMs(double attackMs) {
      this.attackAlpha = alpha(attackMs);
   }   
   
   public void setReleaseMs(double releaseMs) {
      this.releaseAlpha = alpha(releaseMs);
   }
   
   public void setTargetDbfs(double targetDbfs) {
      this.targetDbfs = targetDbfs;
   }

   private double getGateFactor(double currentDbfs) {
      if (currentDbfs < gateTransitionDbfs) return 0.0;
      if (currentDbfs > gateThresholdDbfs) return 1.0;
      
      double position = (currentDbfs - gateTransitionDbfs) * rangeReciprocal;
      return position * position * position;
   }
   
   public double processSample(double sample) {
      // RMS calculation
      double square = sample * sample;
      double alpha = square > meanSquare
         ? attackAlpha
         : releaseAlpha;
      meanSquare = meanSquare * (1.0 - alpha) + square * alpha;
      
      if (meanSquare == 0.0) return sample;
      
      double currentDbfs = 10.0 * Math.log10(meanSquare);
      
      // Gating
      double gateFactor = getGateFactor(currentDbfs);
      if (gateFactor == 0.0) return sample;
      
      // Gaining
      double gainDb = targetDbfs - currentDbfs;
      double fullGain = Math.pow(10, gainDb / 20.0);
      double gain = 1.0 + gateFactor * (fullGain - 1.0);
      double gained = sample * gain;
      double absGained = Math.abs(gained);
      
      if (absGained < PEAK_THRESHOLD) return gained;
      
      double position = absGained - PEAK_THRESHOLD;
      position = position / (1.0 + position * PEAK_RANGE_RECIPROCAL);
      return Math.signum(gained) *
         (PEAK_THRESHOLD + position);
   }
}


//[/user-code-and-variables]
}

 