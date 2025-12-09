package com.vulpuslabs.rkw1;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.modules.piezo.*;


//[/user-imports]


public class RKW1 extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

@SuppressWarnings("this-escape") 
public RKW1( long moduleID, VoltageObjects voltageObjects )
{
   super( moduleID, voltageObjects, "RKW-1", ModuleType.ModuleType_Oscillators, 2.0 );

   InitializeControls();


   canBeBypassed = false;
   SetSkin( "fa1216ce1fd04ede970a0e17ec4f5250" );
}

void InitializeControls()
{

   audioOut = new VoltageAudioJack( "audioOut", "Audio Ou", this, JackType.JackType_AudioOutput );
   AddComponent( audioOut );
   audioOut.SetWantsMouseNotifications( false );
   audioOut.SetPosition( 99, 306 );
   audioOut.SetSize( 37, 37 );
   audioOut.SetSkin( "Jack Straight" );

   voctIn1 = new VoltageAudioJack( "voctIn1", "V/Oct In 1", this, JackType.JackType_AudioInput );
   AddComponent( voctIn1 );
   voctIn1.SetWantsMouseNotifications( false );
   voctIn1.SetPosition( 7, 68 );
   voctIn1.SetSize( 37, 37 );
   voctIn1.SetSkin( "Jack Straight" );

   voctIn2 = new VoltageAudioJack( "voctIn2", "V/Oct In 2", this, JackType.JackType_AudioInput );
   AddComponent( voctIn2 );
   voctIn2.SetWantsMouseNotifications( false );
   voctIn2.SetPosition( 7, 112 );
   voctIn2.SetSize( 37, 37 );
   voctIn2.SetSkin( "Jack Straight" );

   voctIn3 = new VoltageAudioJack( "voctIn3", "V/Oct In 3", this, JackType.JackType_AudioInput );
   AddComponent( voctIn3 );
   voctIn3.SetWantsMouseNotifications( false );
   voctIn3.SetPosition( 6, 152 );
   voctIn3.SetSize( 37, 37 );
   voctIn3.SetSkin( "Jack Straight" );

   voctIn4 = new VoltageAudioJack( "voctIn4", "V/Oct In 4", this, JackType.JackType_AudioInput );
   AddComponent( voctIn4 );
   voctIn4.SetWantsMouseNotifications( false );
   voctIn4.SetPosition( 7, 189 );
   voctIn4.SetSize( 37, 37 );
   voctIn4.SetSkin( "Jack Straight" );

   gateIn1 = new VoltageAudioJack( "gateIn1", "Gate In 1", this, JackType.JackType_AudioInput );
   AddComponent( gateIn1 );
   gateIn1.SetWantsMouseNotifications( false );
   gateIn1.SetPosition( 47, 68 );
   gateIn1.SetSize( 37, 37 );
   gateIn1.SetSkin( "Jack Straight" );

   gateIn2 = new VoltageAudioJack( "gateIn2", "Gate In 2", this, JackType.JackType_AudioInput );
   AddComponent( gateIn2 );
   gateIn2.SetWantsMouseNotifications( false );
   gateIn2.SetPosition( 47, 112 );
   gateIn2.SetSize( 37, 37 );
   gateIn2.SetSkin( "Jack Straight" );

   gateIn3 = new VoltageAudioJack( "gateIn3", "Gate In 3", this, JackType.JackType_AudioInput );
   AddComponent( gateIn3 );
   gateIn3.SetWantsMouseNotifications( false );
   gateIn3.SetPosition( 47, 151 );
   gateIn3.SetSize( 37, 37 );
   gateIn3.SetSkin( "Jack Straight" );

   gateIn4 = new VoltageAudioJack( "gateIn4", "Gate In 4", this, JackType.JackType_AudioInput );
   AddComponent( gateIn4 );
   gateIn4.SetWantsMouseNotifications( false );
   gateIn4.SetPosition( 47, 190 );
   gateIn4.SetSize( 37, 37 );
   gateIn4.SetSkin( "Jack Straight" );

   pulseWidthIn1 = new VoltageAudioJack( "pulseWidthIn1", "Pulse With In 1", this, JackType.JackType_AudioInput );
   AddComponent( pulseWidthIn1 );
   pulseWidthIn1.SetWantsMouseNotifications( false );
   pulseWidthIn1.SetPosition( 88, 69 );
   pulseWidthIn1.SetSize( 37, 37 );
   pulseWidthIn1.SetSkin( "Jack Straight" );

   pulseWidthIn2 = new VoltageAudioJack( "pulseWidthIn2", "Pulse With In 2", this, JackType.JackType_AudioInput );
   AddComponent( pulseWidthIn2 );
   pulseWidthIn2.SetWantsMouseNotifications( false );
   pulseWidthIn2.SetPosition( 88, 112 );
   pulseWidthIn2.SetSize( 37, 37 );
   pulseWidthIn2.SetSkin( "Jack Straight" );

   pulseWidthIn3 = new VoltageAudioJack( "pulseWidthIn3", "Pulse With In 3", this, JackType.JackType_AudioInput );
   AddComponent( pulseWidthIn3 );
   pulseWidthIn3.SetWantsMouseNotifications( false );
   pulseWidthIn3.SetPosition( 90, 148 );
   pulseWidthIn3.SetSize( 37, 37 );
   pulseWidthIn3.SetSkin( "Jack Straight" );

   pulseWidthIn4 = new VoltageAudioJack( "pulseWidthIn4", "Pulse With In 4", this, JackType.JackType_AudioInput );
   AddComponent( pulseWidthIn4 );
   pulseWidthIn4.SetWantsMouseNotifications( false );
   pulseWidthIn4.SetPosition( 88, 188 );
   pulseWidthIn4.SetSize( 37, 37 );
   pulseWidthIn4.SetSkin( "Jack Straight" );
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
      }
      break;
   
      case Jack_Disconnected:   // All cables have been disconnected from this jack
      {
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
   engine.setChannel(
      0,
      voctIn1.GetValue(),
      gateIn1.GetValue() > 0.0,
      0x7FFF + 0x7F0 * pulseWidthIn1.GetValue() * 0.2);

   engine.setChannel(
      1,
      voctIn2.GetValue(),
      gateIn2.GetValue() > 0.0,
      0x7FFF + 0x7F0 * pulseWidthIn2.GetValue() * 0.2);

   engine.setChannel(
      2,
      voctIn3.GetValue(),
      gateIn3.GetValue() > 0.0,
      0x7FFF + 0x7F0 * pulseWidthIn3.GetValue() * 0.2);

   engine.setChannel(
      3,
      voctIn4.GetValue(),
      gateIn4.GetValue() > 0.0,
      0x7FFF + 0x7F0 * pulseWidthIn4.GetValue() * 0.2);
      
   audioOut.SetValue(engine.processSample());
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
private VoltageAudioJack pulseWidthIn4;
private VoltageAudioJack pulseWidthIn3;
private VoltageAudioJack pulseWidthIn2;
private VoltageAudioJack pulseWidthIn1;
private VoltageAudioJack gateIn4;
private VoltageAudioJack gateIn3;
private VoltageAudioJack gateIn2;
private VoltageAudioJack gateIn1;
private VoltageAudioJack voctIn4;
private VoltageAudioJack voctIn3;
private VoltageAudioJack voctIn2;
private VoltageAudioJack voctIn1;
private VoltageAudioJack audioOut;


//[user-code-and-variables]    Add your own variables and functions here
private final SpectrumEngine engine = new SpectrumEngine();




//[/user-code-and-variables]
}

 