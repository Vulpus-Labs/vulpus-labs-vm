package com.vulpuslabs.speccy;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.libs.maths.*;
import com.vulpuslabs.libs.fft.*;
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Random;   


//[/user-imports]


public class Speccy extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   @SuppressWarnings("this-escape") 
   public Speccy( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Speccy", ModuleType.ModuleType_Effect, 0.6 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "84dcfe91c63642dfaa8b04563eb9290a" );
   }

void InitializeControls()
{

      inputJack = new VoltageAudioJack( "inputJack", "Input", this, JackType.JackType_AudioInput );
      AddComponent( inputJack );
      inputJack.SetWantsMouseNotifications( false );
      inputJack.SetPosition( 9, 18 );
      inputJack.SetSize( 25, 25 );
      inputJack.SetSkin( "Jack Round Sky Ring" );

      outputJack = new VoltageAudioJack( "outputJack", "Output", this, JackType.JackType_AudioOutput );
      AddComponent( outputJack );
      outputJack.SetWantsMouseNotifications( false );
      outputJack.SetPosition( 9, 287 );
      outputJack.SetSize( 25, 25 );
      outputJack.SetSkin( "Jack Round Teal Ring" );

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "SPECCY" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 0, 0 );
      textLabel1.SetSize( 43, 15 );
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

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "IN" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 0, 48 );
      textLabel2.SetSize( 43, 15 );
      textLabel2.SetEditable( false, false );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel2.SetBkColor( new Color( 65, 65, 65, 255 ) );
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

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "WIN SIZE" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 0, 88 );
      textLabel7.SetSize( 43, 18 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel7.SetBkColor( new Color( 65, 65, 65, 255 ) );
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

      outLabel = new VoltageLabel( "outLabel", "textLabel4", this, "OUT" );
      AddComponent( outLabel );
      outLabel.SetWantsMouseNotifications( false );
      outLabel.SetPosition( 0, 318 );
      outLabel.SetSize( 43, 15 );
      outLabel.SetEditable( false, false );
      outLabel.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      outLabel.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      outLabel.SetColor( new Color( 255, 255, 255, 255 ) );
      outLabel.SetBkColor( new Color( 65, 65, 65, 255 ) );
      outLabel.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      outLabel.SetBorderSize( 1 );
      outLabel.SetMultiLineEdit( false );
      outLabel.SetIsNumberEditor( false );
      outLabel.SetNumberEditorRange( 0, 100 );
      outLabel.SetNumberEditorInterval( 1 );
      outLabel.SetNumberEditorUsesMouseWheel( false );
      outLabel.SetHasCustomTextHoverColor( false );
      outLabel.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      outLabel.SetFont( "Arial", 10, true, false );

      vulpusLabsLabel = new VoltageLabel( "vulpusLabsLabel", "Vulpus Labs", this, "VULPUS LABS" );
      AddComponent( vulpusLabsLabel );
      vulpusLabsLabel.SetWantsMouseNotifications( false );
      vulpusLabsLabel.SetPosition( 0, 335 );
      vulpusLabsLabel.SetSize( 43, 25 );
      vulpusLabsLabel.SetEditable( false, false );
      vulpusLabsLabel.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      vulpusLabsLabel.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      vulpusLabsLabel.SetColor( new Color( 255, 255, 255, 255 ) );
      vulpusLabsLabel.SetBkColor( new Color( 65, 65, 65, 0 ) );
      vulpusLabsLabel.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      vulpusLabsLabel.SetBorderSize( 1 );
      vulpusLabsLabel.SetMultiLineEdit( true );
      vulpusLabsLabel.SetIsNumberEditor( false );
      vulpusLabsLabel.SetNumberEditorRange( 0, 100 );
      vulpusLabsLabel.SetNumberEditorInterval( 1 );
      vulpusLabsLabel.SetNumberEditorUsesMouseWheel( false );
      vulpusLabsLabel.SetHasCustomTextHoverColor( false );
      vulpusLabsLabel.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      vulpusLabsLabel.SetFont( "Arial", 10, true, false );

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "BAND SIZE" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 0, 158 );
      textLabel6.SetSize( 43, 15 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel6.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel6.SetBorderSize( 1 );
      textLabel6.SetMultiLineEdit( false );
      textLabel6.SetIsNumberEditor( false );
      textLabel6.SetNumberEditorRange( 0, 100 );
      textLabel6.SetNumberEditorInterval( 1 );
      textLabel6.SetNumberEditorUsesMouseWheel( false );
      textLabel6.SetHasCustomTextHoverColor( false );
      textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetFont( "Arial", 10, true, false );

      feedbackKnob = new VoltageKnob( "feedbackKnob", "Feedback", this, 0, 0.99, 0 );
      AddComponent( feedbackKnob );
      feedbackKnob.SetWantsMouseNotifications( false );
      feedbackKnob.SetPosition( 9, 177 );
      feedbackKnob.SetSize( 27, 27 );
      feedbackKnob.SetSkin( "Plastic Mint" );
      feedbackKnob.SetRange( 0, 0.99, 0, false, 0 );
      feedbackKnob.SetKnobParams( 215, 145 );
      feedbackKnob.DisplayValueInPercent( true );
      feedbackKnob.SetKnobAdjustsRing( true );

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "FBCK" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 0, 208 );
      textLabel9.SetSize( 43, 15 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel9.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel9.SetBorderSize( 1 );
      textLabel9.SetMultiLineEdit( false );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "Arial", 10, true, false );

      mixKnob = new VoltageKnob( "mixKnob", "Mix", this, 0, 1, 0.2 );
      AddComponent( mixKnob );
      mixKnob.SetWantsMouseNotifications( false );
      mixKnob.SetPosition( 9, 229 );
      mixKnob.SetSize( 27, 27 );
      mixKnob.SetSkin( "Plastic Blue" );
      mixKnob.SetRange( 0, 1, 0.2, false, 0 );
      mixKnob.SetKnobParams( 215, 145 );
      mixKnob.DisplayValueInPercent( true );
      mixKnob.SetKnobAdjustsRing( true );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "MIX" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 0, 260 );
      textLabel10.SetSize( 43, 15 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 65, 65, 65, 255 ) );
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

      windowSizeSlider = new VoltageSlider( "windowSizeSlider", "Window Size", this, false, 1, 6, 3, 6 );
      AddComponent( windowSizeSlider );
      windowSizeSlider.SetWantsMouseNotifications( false );
      windowSizeSlider.SetPosition( 3, 73 );
      windowSizeSlider.SetSize( 37, 16 );
      windowSizeSlider.SetSkin( "Straight Black Plain Horizontal" );
      windowSizeSlider.DisplayValueInPercent( false );

      seedLabel = new VoltageLabel( "seedLabel", "seed label", this, "SEED" );
      AddComponent( seedLabel );
      seedLabel.SetWantsMouseNotifications( false );
      seedLabel.SetPosition( 0, 123 );
      seedLabel.SetSize( 43, 15 );
      seedLabel.SetEditable( false, false );
      seedLabel.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      seedLabel.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      seedLabel.SetColor( new Color( 255, 255, 255, 255 ) );
      seedLabel.SetBkColor( new Color( 65, 65, 65, 255 ) );
      seedLabel.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      seedLabel.SetBorderSize( 1 );
      seedLabel.SetMultiLineEdit( false );
      seedLabel.SetIsNumberEditor( false );
      seedLabel.SetNumberEditorRange( 0, 100 );
      seedLabel.SetNumberEditorInterval( 1 );
      seedLabel.SetNumberEditorUsesMouseWheel( false );
      seedLabel.SetHasCustomTextHoverColor( false );
      seedLabel.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      seedLabel.SetFont( "Arial", 10, true, false );

      seedSlider = new VoltageSlider( "seedSlider", "Random Seed Slider", this, false, 1, 50, 25, 50 );
      AddComponent( seedSlider );
      seedSlider.SetWantsMouseNotifications( false );
      seedSlider.SetPosition( 3, 108 );
      seedSlider.SetSize( 37, 13 );
      seedSlider.SetSkin( "Straight Black Plain Horizontal" );
      seedSlider.DisplayValueInPercent( false );

      bandSizeSlider = new VoltageSlider( "bandSizeSlider", "Band Size", this, false, 0, 4, 0, 5 );
      AddComponent( bandSizeSlider );
      bandSizeSlider.SetWantsMouseNotifications( false );
      bandSizeSlider.SetPosition( 4, 142 );
      bandSizeSlider.SetSize( 37, 13 );
      bandSizeSlider.SetSkin( "Straight Black Plain Horizontal" );
      bandSizeSlider.DisplayValueInPercent( false );

      overflowWarningLED = new VoltageLED( "overflowWarningLED", "Overflow Warning", this );
      AddComponent( overflowWarningLED );
      overflowWarningLED.SetWantsMouseNotifications( true );
      overflowWarningLED.SetPosition( 32, 278 );
      overflowWarningLED.SetSize( 11, 11 );
      overflowWarningLED.SetSkin( "Red" );
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
      initialiseBuffers();
      StartGuiUpdateTimer();
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
      processor.stop();
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
            if (component == mixKnob) {
               transformer.setMix(doubleValue);
            } else if (component == feedbackKnob) {
               transformer.setFeedbackAmount(doubleValue);
            }
         }
         break;
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
            if (component == windowSizeSlider) {
               var newWindowSizePower = (int) doubleValue - 1;
               if (newWindowSizePower != windowSizePower) {
                  windowSizePower = newWindowSizePower;
                  initialiseBuffers();
               }
            } else if (component == seedSlider) {
               transformer.setSeed((long) doubleValue);
            } else {
               transformer.setBandSize((int) doubleValue);
            }
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
            var isOverflow = processor.checkOverflowWarning();
            overflowWarningLED.SetValue(isOverflow ? 1.0 : 0.0);
         }
         break;
      
         case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
            if (component == overflowWarningLED) {
               SetMouseCursor(MouseCursorTypes.PointingHand);
            }
         }
         break;
      
         case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
            if (component == overflowWarningLED) {
               SetMouseCursor(MouseCursorTypes.Normal);
            }
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
            if (component == overflowWarningLED) {
               int menuSelected = ShowDropDownMenu(new String[] {
                  "Read Buffer Offset",
                  "{sep}",
                  "128 samples",
                  "256 samples",
                  "384 samples",
                  "512 samples",
                  "640 samples",
                  "768 samples",
                  "892 samples",
                  "1024 samples"},
                  minReadOffsetMultiple + 1,
                  overflowWarningLED);
               if (menuSelected > 1) {
                  minReadOffsetMultiple = menuSelected - 1;
                  initialiseBuffers();
               }
            }
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
      outputJack.SetValue(
         5.0 * Approximate.tanh(
            0.2 * processor.processSample(inputJack.GetValue())
         )
      );


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
      if (component == windowSizeSlider) {
         return windowSize + " samples";
      }
      
      if (component == bandSizeSlider) {
         return (1 << (int) bandSizeSlider.GetValue()) + " bands";
      }
      
      if (component == overflowWarningLED) {
         return "Output latency " + processor.getOutputLatency() + " samples";
      }
         
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
      return new byte[] { (byte) minReadOffsetMultiple };
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
      minReadOffsetMultiple = (int) stateInfo[0];
      initialiseBuffers();
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
   private VoltageLED overflowWarningLED;
   private VoltageSlider bandSizeSlider;
   private VoltageSlider seedSlider;
   private VoltageLabel seedLabel;
   private VoltageSlider windowSizeSlider;
   private VoltageLabel textLabel10;
   private VoltageKnob mixKnob;
   private VoltageLabel textLabel9;
   private VoltageKnob feedbackKnob;
   private VoltageLabel textLabel6;
   private VoltageLabel vulpusLabsLabel;
   private VoltageLabel outLabel;
   private VoltageLabel textLabel7;
   private VoltageLabel textLabel2;
   private VoltageLabel textLabel1;
   private VoltageAudioJack outputJack;
   private VoltageAudioJack inputJack;


   //[user-code-and-variables]    Add your own variables and functions here
private volatile FFTProcessor processor;
private DelayTransformer transformer;

private int windowSize;
private int windowSizePower;
private int minReadOffsetMultiple = 1;

private void initialiseBuffers() {
   if (processor != null) processor.stop();
   
   windowSize = 64 << windowSizePower;
   int binSize = windowSize << 1;
   int minReadOffset = 128 * minReadOffsetMultiple;
   
   DelayTransformer newTransformer = new DelayTransformer(windowSize);
   if (transformer != null) newTransformer.copyConfigurationFrom(transformer);
   transformer = newTransformer;
   
   processor = new FFTProcessor(windowSize, 4096, minReadOffset, transformer);
   processor.start();
}

private static final class DelayTransformer implements FFTTransformer {

   private final double[][][] delayBuffer;
   private final Random random = new Random();
   
   private int delayPtr = 0;
   
   private int bandMask = 0;
   private long seed = 0L;
   private double dryAmount = 1.0;
   private double wetAmount = 0.0;
   private double feedbackAmount = 0.0;
   
   public DelayTransformer(int windowSize) {
      this.delayBuffer = new double[256][windowSize][2];
   }
   
   public void setSeed(long seed) {
      this.seed = seed;
   }
   
   public void setBandSize(int bandSizePower) {
      bandMask = (1 << bandSizePower) - 1;
   }
   
   public void setMix(double wetAmount) {
      this.wetAmount = wetAmount;
      this.dryAmount = 1.0 - wetAmount;
   }
   
   public void setFeedbackAmount(double feedbackAmount) {
      this.feedbackAmount = feedbackAmount;
   }
   
   public void copyConfigurationFrom(DelayTransformer other) {
      this.seed = other.seed;
      this.dryAmount = other.dryAmount;
      this.wetAmount = other.wetAmount;
      this.feedbackAmount = other.feedbackAmount;
      this.bandMask = other.bandMask;
   }
   
   @Override
   public void transform(double[][] fftBins) {
      int binSize = fftBins.length;
      int lowPtr = 1;
      int highPtr = binSize - 1;

      random.setSeed(seed);

      final double[][] delayAtPtr = delayBuffer[delayPtr++];
      delayPtr = delayPtr & 255;

      int offset = 0;
      int bandCount = 0;
      
      while (lowPtr < highPtr) {
         if (bandCount++ == 0) {
            offset = (delayPtr + random.nextInt(1, 256)) & 255;
         }
         bandCount &= bandMask;

         final double[] delayRead = delayBuffer[offset][lowPtr];
         final double[] delayWrite = delayAtPtr[lowPtr];
         final double[] lowBin = fftBins[lowPtr];
         final double[] highBin = fftBins[highPtr];

         final double delayReadR = delayRead[0];
         final double delayReadI = delayRead[1];
      
         final double readR = lowBin[0];
         final double readI = lowBin[1];
      
         delayWrite[0] = readR + (delayReadR * feedbackAmount);
         delayWrite[1] = readI + (delayReadI * feedbackAmount);
      
         final double writeR = (delayReadR * wetAmount) + (readR * dryAmount);
         final double writeI = (delayReadI * wetAmount) + (readI * dryAmount);
      
         lowBin[0] = writeR;
         lowBin[1] = writeI;
         highBin[0] = writeR;
         highBin[1] = -writeI;
      
         lowPtr++;
         highPtr--;
      }
   }
}




   //[/user-code-and-variables]
}

 