package com.vulpuslabs.catkinsstereo;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.modules.catkins.*;
import com.vulpuslabs.vulpes.values.inputs.CvModulatableKnob;
import com.vulpuslabs.vulpes.values.events.NotificationReceiver;


//[/user-imports]


public class CatkinsStereo extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public CatkinsStereo( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Catkins Stereo", ModuleType.ModuleType_Effect, 3.0 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "ff71793fcc74424ca2422fe33da6ea00" );
   }

void InitializeControls()
{

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "MIX" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 109, 18 );
      textLabel4.SetSize( 33, 28 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel4.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel4.SetBorderSize( 2 );
      textLabel4.SetMultiLineEdit( false );
      textLabel4.SetIsNumberEditor( false );
      textLabel4.SetNumberEditorRange( 0, 100 );
      textLabel4.SetNumberEditorInterval( 1 );
      textLabel4.SetNumberEditorUsesMouseWheel( false );
      textLabel4.SetHasCustomTextHoverColor( false );
      textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetFont( "Arial", 10, true, false );

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "FBCK" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 74, 18 );
      textLabel3.SetSize( 33, 28 );
      textLabel3.SetEditable( false, false );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel3.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel3.SetBorderSize( 2 );
      textLabel3.SetMultiLineEdit( false );
      textLabel3.SetIsNumberEditor( false );
      textLabel3.SetNumberEditorRange( 0, 100 );
      textLabel3.SetNumberEditorInterval( 1 );
      textLabel3.SetNumberEditorUsesMouseWheel( false );
      textLabel3.SetHasCustomTextHoverColor( false );
      textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetFont( "Arial", 10, true, false );

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "OUT L" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 145, 18 );
      textLabel2.SetSize( 33, 28 );
      textLabel2.SetEditable( false, false );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel2.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel2.SetBorderSize( 2 );
      textLabel2.SetMultiLineEdit( false );
      textLabel2.SetIsNumberEditor( false );
      textLabel2.SetNumberEditorRange( 0, 100 );
      textLabel2.SetNumberEditorInterval( 1 );
      textLabel2.SetNumberEditorUsesMouseWheel( false );
      textLabel2.SetHasCustomTextHoverColor( false );
      textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel2.SetFont( "Arial", 10, true, false );

      textLabel20 = new VoltageLabel( "textLabel20", "textLabel20", this, "OUT R" );
      AddComponent( textLabel20 );
      textLabel20.SetWantsMouseNotifications( false );
      textLabel20.SetPosition( 179, 18 );
      textLabel20.SetSize( 33, 28 );
      textLabel20.SetEditable( false, false );
      textLabel20.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel20.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel20.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel20.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel20.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel20.SetBorderSize( 2 );
      textLabel20.SetMultiLineEdit( false );
      textLabel20.SetIsNumberEditor( false );
      textLabel20.SetNumberEditorRange( 0, 100 );
      textLabel20.SetNumberEditorInterval( 1 );
      textLabel20.SetNumberEditorUsesMouseWheel( false );
      textLabel20.SetHasCustomTextHoverColor( false );
      textLabel20.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel20.SetFont( "Arial", 10, true, false );

      textLabel19 = new VoltageLabel( "textLabel19", "textLabel19", this, "IN R" );
      AddComponent( textLabel19 );
      textLabel19.SetWantsMouseNotifications( false );
      textLabel19.SetPosition( 38, 18 );
      textLabel19.SetSize( 33, 28 );
      textLabel19.SetEditable( false, false );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel19.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel19.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel19.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel19.SetBorderSize( 2 );
      textLabel19.SetMultiLineEdit( false );
      textLabel19.SetIsNumberEditor( false );
      textLabel19.SetNumberEditorRange( 0, 100 );
      textLabel19.SetNumberEditorInterval( 1 );
      textLabel19.SetNumberEditorUsesMouseWheel( false );
      textLabel19.SetHasCustomTextHoverColor( false );
      textLabel19.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel19.SetFont( "Arial", 10, true, false );

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "IN L" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 4, 18 );
      textLabel1.SetSize( 33, 28 );
      textLabel1.SetEditable( false, false );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel1.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel1.SetBorderSize( 2 );
      textLabel1.SetMultiLineEdit( false );
      textLabel1.SetIsNumberEditor( false );
      textLabel1.SetNumberEditorRange( 0, 100 );
      textLabel1.SetNumberEditorInterval( 1 );
      textLabel1.SetNumberEditorUsesMouseWheel( false );
      textLabel1.SetHasCustomTextHoverColor( false );
      textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel1.SetFont( "Arial", 10, true, false );

      inputJackRight = new VoltageAudioJack( "inputJackRight", "Input Righ", this, JackType.JackType_AudioInput );
      AddComponent( inputJackRight );
      inputJackRight.SetWantsMouseNotifications( false );
      inputJackRight.SetPosition( 42, 32 );
      inputJackRight.SetSize( 25, 25 );
      inputJackRight.SetSkin( "Mini Jack 25px" );

      inputJackLeft = new VoltageAudioJack( "inputJackLeft", "Input Left (Mono)", this, JackType.JackType_AudioInput );
      AddComponent( inputJackLeft );
      inputJackLeft.SetWantsMouseNotifications( false );
      inputJackLeft.SetPosition( 8, 32 );
      inputJackLeft.SetSize( 25, 25 );
      inputJackLeft.SetSkin( "Mini Jack 25px" );

      outputJackLeft = new VoltageAudioJack( "outputJackLeft", "Output Left", this, JackType.JackType_AudioOutput );
      AddComponent( outputJackLeft );
      outputJackLeft.SetWantsMouseNotifications( false );
      outputJackLeft.SetPosition( 149, 32 );
      outputJackLeft.SetSize( 25, 25 );
      outputJackLeft.SetSkin( "Mini Jack 25px" );

      outputJackRight = new VoltageAudioJack( "outputJackRight", "Output Right", this, JackType.JackType_AudioOutput );
      AddComponent( outputJackRight );
      outputJackRight.SetWantsMouseNotifications( false );
      outputJackRight.SetPosition( 183, 32 );
      outputJackRight.SetSize( 25, 25 );
      outputJackRight.SetSkin( "Mini Jack 25px" );

      feedbackKnob = new VoltageKnob( "feedbackKnob", "Feedback", this, 0.0, 1.0, 0.0 );
      AddComponent( feedbackKnob );
      feedbackKnob.SetWantsMouseNotifications( false );
      feedbackKnob.SetPosition( 77, 32 );
      feedbackKnob.SetSize( 27, 27 );
      feedbackKnob.SetSkin( "Plastic Mint" );
      feedbackKnob.SetRange( 0.0, 1.0, 0.0, false, 0 );
      feedbackKnob.SetKnobParams( 215, 145 );
      feedbackKnob.DisplayValueInPercent( true );
      feedbackKnob.SetKnobAdjustsRing( true );

      mixKnob = new VoltageKnob( "mixKnob", "Wet/Dry Mix", this, 0.0, 1.0, 0.5 );
      AddComponent( mixKnob );
      mixKnob.SetWantsMouseNotifications( false );
      mixKnob.SetPosition( 112, 32 );
      mixKnob.SetSize( 27, 27 );
      mixKnob.SetSkin( "Plastic Orange" );
      mixKnob.SetRange( 0.0, 1.0, 0.5, false, 0 );
      mixKnob.SetKnobParams( 215, 145 );
      mixKnob.DisplayValueInPercent( false );
      mixKnob.SetKnobAdjustsRing( true );

      feedbackModCv = new VoltageAudioJack( "feedbackModCv", "Feedback Mod CV", this, JackType.JackType_AudioInput );
      AddComponent( feedbackModCv );
      feedbackModCv.SetWantsMouseNotifications( false );
      feedbackModCv.SetPosition( 53, 62 );
      feedbackModCv.SetSize( 25, 25 );
      feedbackModCv.SetSkin( "Mini Jack 25px" );

      mixModCv = new VoltageAudioJack( "mixModCv", "Mix Mod CV", this, JackType.JackType_AudioInput );
      AddComponent( mixModCv );
      mixModCv.SetWantsMouseNotifications( false );
      mixModCv.SetPosition( 138, 62 );
      mixModCv.SetSize( 25, 25 );
      mixModCv.SetSkin( "Mini Jack 25px" );

      feedbackModAmount = new VoltageKnob( "feedbackModAmount", "Feedback Mod Amount", this, 0.0, 1.0, 0.5 );
      AddComponent( feedbackModAmount );
      feedbackModAmount.SetWantsMouseNotifications( false );
      feedbackModAmount.SetPosition( 84, 67 );
      feedbackModAmount.SetSize( 15, 15 );
      feedbackModAmount.SetSkin( "ARP2500 Sm Silver" );
      feedbackModAmount.SetRange( 0.0, 1.0, 0.5, false, 0 );
      feedbackModAmount.SetKnobParams( 215, 145 );
      feedbackModAmount.DisplayValueInPercent( false );
      feedbackModAmount.SetKnobAdjustsRing( true );

      mixModAmount = new VoltageKnob( "mixModAmount", "Mix Mod Amount", this, 0.0, 1.0, 0.5 );
      AddComponent( mixModAmount );
      mixModAmount.SetWantsMouseNotifications( false );
      mixModAmount.SetPosition( 118, 67 );
      mixModAmount.SetSize( 15, 15 );
      mixModAmount.SetSkin( "ARP2500 Sm Silver" );
      mixModAmount.SetRange( 0.0, 1.0, 0.5, false, 0 );
      mixModAmount.SetKnobParams( 215, 145 );
      mixModAmount.DisplayValueInPercent( false );
      mixModAmount.SetKnobAdjustsRing( true );

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "CATKINS STEREO" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 0, 0 );
      textLabel5.SetSize( 216, 15 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel5.SetBkColor( new Color( 0, 0, 0, 0 ) );
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

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "VULPUS LABS" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 0, 345 );
      textLabel6.SetSize( 216, 15 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel6.SetBkColor( new Color( 0, 0, 0, 0 ) );
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

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "POS" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 4, 93 );
      textLabel7.SetSize( 33, 14 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel7.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel7.SetBorderSize( 2 );
      textLabel7.SetMultiLineEdit( false );
      textLabel7.SetIsNumberEditor( false );
      textLabel7.SetNumberEditorRange( 0, 100 );
      textLabel7.SetNumberEditorInterval( 1 );
      textLabel7.SetNumberEditorUsesMouseWheel( false );
      textLabel7.SetHasCustomTextHoverColor( false );
      textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetFont( "Arial", 10, true, false );

      textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "10ms" );
      AddComponent( textLabel13 );
      textLabel13.SetWantsMouseNotifications( false );
      textLabel13.SetPosition( 68, 310 );
      textLabel13.SetSize( 20, 14 );
      textLabel13.SetEditable( false, false );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel13.SetBorderSize( 2 );
      textLabel13.SetMultiLineEdit( false );
      textLabel13.SetIsNumberEditor( false );
      textLabel13.SetNumberEditorRange( 0, 100 );
      textLabel13.SetNumberEditorInterval( 1 );
      textLabel13.SetNumberEditorUsesMouseWheel( false );
      textLabel13.SetHasCustomTextHoverColor( false );
      textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel13.SetFont( "Arial", 10, true, false );

      textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "10s" );
      AddComponent( textLabel14 );
      textLabel14.SetWantsMouseNotifications( false );
      textLabel14.SetPosition( 130, 310 );
      textLabel14.SetSize( 20, 14 );
      textLabel14.SetEditable( false, false );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel14.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel14.SetBorderSize( 2 );
      textLabel14.SetMultiLineEdit( false );
      textLabel14.SetIsNumberEditor( false );
      textLabel14.SetNumberEditorRange( 0, 100 );
      textLabel14.SetNumberEditorInterval( 1 );
      textLabel14.SetNumberEditorUsesMouseWheel( false );
      textLabel14.SetHasCustomTextHoverColor( false );
      textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel14.SetFont( "Arial", 10, true, false );

      textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "RANGE" );
      AddComponent( textLabel15 );
      textLabel15.SetWantsMouseNotifications( false );
      textLabel15.SetPosition( 14, 310 );
      textLabel15.SetSize( 50, 14 );
      textLabel15.SetEditable( false, false );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel15.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel15.SetBorderSize( 2 );
      textLabel15.SetMultiLineEdit( false );
      textLabel15.SetIsNumberEditor( false );
      textLabel15.SetNumberEditorRange( 0, 100 );
      textLabel15.SetNumberEditorInterval( 1 );
      textLabel15.SetNumberEditorUsesMouseWheel( false );
      textLabel15.SetHasCustomTextHoverColor( false );
      textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel15.SetFont( "Arial", 10, true, false );

      textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "QUALITY" );
      AddComponent( textLabel16 );
      textLabel16.SetWantsMouseNotifications( false );
      textLabel16.SetPosition( 14, 327 );
      textLabel16.SetSize( 50, 14 );
      textLabel16.SetEditable( false, false );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel16.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel16.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel16.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel16.SetBorderSize( 2 );
      textLabel16.SetMultiLineEdit( false );
      textLabel16.SetIsNumberEditor( false );
      textLabel16.SetNumberEditorRange( 0, 100 );
      textLabel16.SetNumberEditorInterval( 1 );
      textLabel16.SetNumberEditorUsesMouseWheel( false );
      textLabel16.SetHasCustomTextHoverColor( false );
      textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel16.SetFont( "Arial", 10, true, false );

      textLabel17 = new VoltageLabel( "textLabel17", "textLabel17", this, "LOW" );
      AddComponent( textLabel17 );
      textLabel17.SetWantsMouseNotifications( false );
      textLabel17.SetPosition( 68, 327 );
      textLabel17.SetSize( 20, 14 );
      textLabel17.SetEditable( false, false );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel17.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel17.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel17.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel17.SetBorderSize( 2 );
      textLabel17.SetMultiLineEdit( false );
      textLabel17.SetIsNumberEditor( false );
      textLabel17.SetNumberEditorRange( 0, 100 );
      textLabel17.SetNumberEditorInterval( 1 );
      textLabel17.SetNumberEditorUsesMouseWheel( false );
      textLabel17.SetHasCustomTextHoverColor( false );
      textLabel17.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel17.SetFont( "Arial", 10, true, false );

      textLabel18 = new VoltageLabel( "textLabel18", "textLabel18", this, "HIGH" );
      AddComponent( textLabel18 );
      textLabel18.SetWantsMouseNotifications( false );
      textLabel18.SetPosition( 129, 327 );
      textLabel18.SetSize( 20, 14 );
      textLabel18.SetEditable( false, false );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel18.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel18.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel18.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel18.SetBorderSize( 2 );
      textLabel18.SetMultiLineEdit( false );
      textLabel18.SetIsNumberEditor( false );
      textLabel18.SetNumberEditorRange( 0, 100 );
      textLabel18.SetNumberEditorInterval( 1 );
      textLabel18.SetNumberEditorUsesMouseWheel( false );
      textLabel18.SetHasCustomTextHoverColor( false );
      textLabel18.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel18.SetFont( "Arial", 10, true, false );

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "MOD" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 38, 93 );
      textLabel8.SetSize( 33, 14 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel8.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel8.SetBorderSize( 2 );
      textLabel8.SetMultiLineEdit( false );
      textLabel8.SetIsNumberEditor( false );
      textLabel8.SetNumberEditorRange( 0, 100 );
      textLabel8.SetNumberEditorInterval( 1 );
      textLabel8.SetNumberEditorUsesMouseWheel( false );
      textLabel8.SetHasCustomTextHoverColor( false );
      textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetFont( "Arial", 10, true, false );

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "SND L" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 72, 93 );
      textLabel9.SetSize( 35, 14 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel9.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel9.SetBorderSize( 2 );
      textLabel9.SetMultiLineEdit( false );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "Arial", 10, true, false );

      textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "SND R" );
      AddComponent( textLabel12 );
      textLabel12.SetWantsMouseNotifications( false );
      textLabel12.SetPosition( 143, 93 );
      textLabel12.SetSize( 34, 14 );
      textLabel12.SetEditable( false, false );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel12.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel12.SetBorderSize( 2 );
      textLabel12.SetMultiLineEdit( false );
      textLabel12.SetIsNumberEditor( false );
      textLabel12.SetNumberEditorRange( 0, 100 );
      textLabel12.SetNumberEditorInterval( 1 );
      textLabel12.SetNumberEditorUsesMouseWheel( false );
      textLabel12.SetHasCustomTextHoverColor( false );
      textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel12.SetFont( "Arial", 10, true, false );

      textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "RET R" );
      AddComponent( textLabel11 );
      textLabel11.SetWantsMouseNotifications( false );
      textLabel11.SetPosition( 178, 93 );
      textLabel11.SetSize( 34, 14 );
      textLabel11.SetEditable( false, false );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel11.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel11.SetBorderSize( 2 );
      textLabel11.SetMultiLineEdit( false );
      textLabel11.SetIsNumberEditor( false );
      textLabel11.SetNumberEditorRange( 0, 100 );
      textLabel11.SetNumberEditorInterval( 1 );
      textLabel11.SetNumberEditorUsesMouseWheel( false );
      textLabel11.SetHasCustomTextHoverColor( false );
      textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetFont( "Arial", 10, true, false );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "RET L" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 108, 93 );
      textLabel10.SetSize( 34, 14 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel10.SetBorderSize( 2 );
      textLabel10.SetMultiLineEdit( false );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "Arial", 10, true, false );

      qualitySwitch = new VoltageSwitch( "qualitySwitch", "Quality", this, 0 );
      AddComponent( qualitySwitch );
      qualitySwitch.SetWantsMouseNotifications( false );
      qualitySwitch.SetPosition( 91, 327 );
      qualitySwitch.SetSize( 37, 15 );
      qualitySwitch.SetSkin( "Rocker Switch Plastic Orange Hor" );

      head1PositionMod = new VoltageAudioJack( "head1PositionMod", "Head 1 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head1PositionMod );
      head1PositionMod.SetWantsMouseNotifications( false );
      head1PositionMod.SetPosition( 41, 112 );
      head1PositionMod.SetSize( 25, 25 );
      head1PositionMod.SetSkin( "Mini Jack 25px" );

      head4PositionMod = new VoltageAudioJack( "head4PositionMod", "Head 4 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head4PositionMod );
      head4PositionMod.SetWantsMouseNotifications( false );
      head4PositionMod.SetPosition( 41, 212 );
      head4PositionMod.SetSize( 25, 25 );
      head4PositionMod.SetSkin( "Mini Jack 25px" );

      head1Position = new VoltageKnob( "head1Position", "Head 1 Position", this, 0.0, 1, 0.50 );
      AddComponent( head1Position );
      head1Position.SetWantsMouseNotifications( false );
      head1Position.SetPosition( 8, 112 );
      head1Position.SetSize( 27, 27 );
      head1Position.SetSkin( "Plastic Blue" );
      head1Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head1Position.SetKnobParams( 215, 145 );
      head1Position.SetUnits( "s" );
      head1Position.DisplayValueInPercent( false );
      head1Position.SetKnobAdjustsRing( true );

      head4Position = new VoltageKnob( "head4Position", "Head 4 Position", this, 0.0, 1, 0.50 );
      AddComponent( head4Position );
      head4Position.SetWantsMouseNotifications( false );
      head4Position.SetPosition( 8, 212 );
      head4Position.SetSize( 27, 27 );
      head4Position.SetSkin( "Plastic Blue" );
      head4Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head4Position.SetKnobParams( 215, 145 );
      head4Position.SetUnits( "s" );
      head4Position.DisplayValueInPercent( false );
      head4Position.SetKnobAdjustsRing( true );

      head1SendLeft = new VoltageAudioJack( "head1SendLeft", "Head 1 Send Left", this, JackType.JackType_AudioOutput );
      AddComponent( head1SendLeft );
      head1SendLeft.SetWantsMouseNotifications( false );
      head1SendLeft.SetPosition( 76, 112 );
      head1SendLeft.SetSize( 25, 25 );
      head1SendLeft.SetSkin( "Mini Jack 25px" );

      head1SendRight = new VoltageAudioJack( "head1SendRight", "Head 1 Send Right", this, JackType.JackType_AudioOutput );
      AddComponent( head1SendRight );
      head1SendRight.SetWantsMouseNotifications( false );
      head1SendRight.SetPosition( 147, 112 );
      head1SendRight.SetSize( 25, 25 );
      head1SendRight.SetSkin( "Mini Jack 25px" );

      head4SendLeft = new VoltageAudioJack( "head4SendLeft", "Head 4 Send Left", this, JackType.JackType_AudioOutput );
      AddComponent( head4SendLeft );
      head4SendLeft.SetWantsMouseNotifications( false );
      head4SendLeft.SetPosition( 76, 212 );
      head4SendLeft.SetSize( 25, 25 );
      head4SendLeft.SetSkin( "Mini Jack 25px" );

      head4SendRight = new VoltageAudioJack( "head4SendRight", "Head 4 Send Right", this, JackType.JackType_AudioOutput );
      AddComponent( head4SendRight );
      head4SendRight.SetWantsMouseNotifications( false );
      head4SendRight.SetPosition( 147, 212 );
      head4SendRight.SetSize( 25, 25 );
      head4SendRight.SetSkin( "Mini Jack 25px" );

      head1ReturnLeft = new VoltageAudioJack( "head1ReturnLeft", "Head 1 Return Left", this, JackType.JackType_AudioInput );
      AddComponent( head1ReturnLeft );
      head1ReturnLeft.SetWantsMouseNotifications( false );
      head1ReturnLeft.SetPosition( 112, 112 );
      head1ReturnLeft.SetSize( 25, 25 );
      head1ReturnLeft.SetSkin( "Mini Jack 25px" );

      head1ReturnRight = new VoltageAudioJack( "head1ReturnRight", "Head 1 Return Right", this, JackType.JackType_AudioInput );
      AddComponent( head1ReturnRight );
      head1ReturnRight.SetWantsMouseNotifications( false );
      head1ReturnRight.SetPosition( 182, 112 );
      head1ReturnRight.SetSize( 25, 25 );
      head1ReturnRight.SetSkin( "Mini Jack 25px" );

      head4ReturnLeft = new VoltageAudioJack( "head4ReturnLeft", "Head 4 Return Left", this, JackType.JackType_AudioInput );
      AddComponent( head4ReturnLeft );
      head4ReturnLeft.SetWantsMouseNotifications( false );
      head4ReturnLeft.SetPosition( 112, 212 );
      head4ReturnLeft.SetSize( 25, 25 );
      head4ReturnLeft.SetSkin( "Mini Jack 25px" );

      head4ReturnRight = new VoltageAudioJack( "head4ReturnRight", "Head 4 Return Right", this, JackType.JackType_AudioInput );
      AddComponent( head4ReturnRight );
      head4ReturnRight.SetWantsMouseNotifications( false );
      head4ReturnRight.SetPosition( 182, 212 );
      head4ReturnRight.SetSize( 25, 25 );
      head4ReturnRight.SetSkin( "Mini Jack 25px" );

      head2PositionMod = new VoltageAudioJack( "head2PositionMod", "Head 2 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head2PositionMod );
      head2PositionMod.SetWantsMouseNotifications( false );
      head2PositionMod.SetPosition( 41, 145 );
      head2PositionMod.SetSize( 25, 25 );
      head2PositionMod.SetSkin( "Mini Jack 25px" );

      head5PositionMod = new VoltageAudioJack( "head5PositionMod", "Head 5 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head5PositionMod );
      head5PositionMod.SetWantsMouseNotifications( false );
      head5PositionMod.SetPosition( 41, 244 );
      head5PositionMod.SetSize( 25, 25 );
      head5PositionMod.SetSkin( "Mini Jack 25px" );

      head2Position = new VoltageKnob( "head2Position", "Head 2 Position", this, 0.0, 1, 0.50 );
      AddComponent( head2Position );
      head2Position.SetWantsMouseNotifications( false );
      head2Position.SetPosition( 8, 145 );
      head2Position.SetSize( 27, 27 );
      head2Position.SetSkin( "Plastic Blue" );
      head2Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head2Position.SetKnobParams( 215, 145 );
      head2Position.SetUnits( "s" );
      head2Position.DisplayValueInPercent( false );
      head2Position.SetKnobAdjustsRing( true );

      head5Position = new VoltageKnob( "head5Position", "Head 5 Position", this, 0.0, 1, 0.50 );
      AddComponent( head5Position );
      head5Position.SetWantsMouseNotifications( false );
      head5Position.SetPosition( 8, 244 );
      head5Position.SetSize( 27, 27 );
      head5Position.SetSkin( "Plastic Blue" );
      head5Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head5Position.SetKnobParams( 215, 145 );
      head5Position.SetUnits( "s" );
      head5Position.DisplayValueInPercent( false );
      head5Position.SetKnobAdjustsRing( true );

      head2SendLeft = new VoltageAudioJack( "head2SendLeft", "Head 2 Send Left", this, JackType.JackType_AudioOutput );
      AddComponent( head2SendLeft );
      head2SendLeft.SetWantsMouseNotifications( false );
      head2SendLeft.SetPosition( 76, 145 );
      head2SendLeft.SetSize( 25, 25 );
      head2SendLeft.SetSkin( "Mini Jack 25px" );

      head2SendRight = new VoltageAudioJack( "head2SendRight", "Head 2 Send Right", this, JackType.JackType_AudioOutput );
      AddComponent( head2SendRight );
      head2SendRight.SetWantsMouseNotifications( false );
      head2SendRight.SetPosition( 147, 145 );
      head2SendRight.SetSize( 25, 25 );
      head2SendRight.SetSkin( "Mini Jack 25px" );

      head5SendLeft = new VoltageAudioJack( "head5SendLeft", "Head 5 Send Left", this, JackType.JackType_AudioOutput );
      AddComponent( head5SendLeft );
      head5SendLeft.SetWantsMouseNotifications( false );
      head5SendLeft.SetPosition( 76, 244 );
      head5SendLeft.SetSize( 25, 25 );
      head5SendLeft.SetSkin( "Mini Jack 25px" );

      head5SendRight = new VoltageAudioJack( "head5SendRight", "Head 5 Send Right", this, JackType.JackType_AudioOutput );
      AddComponent( head5SendRight );
      head5SendRight.SetWantsMouseNotifications( false );
      head5SendRight.SetPosition( 147, 244 );
      head5SendRight.SetSize( 25, 25 );
      head5SendRight.SetSkin( "Mini Jack 25px" );

      head2ReturnLeft = new VoltageAudioJack( "head2ReturnLeft", "Head 2 Return Left", this, JackType.JackType_AudioInput );
      AddComponent( head2ReturnLeft );
      head2ReturnLeft.SetWantsMouseNotifications( false );
      head2ReturnLeft.SetPosition( 112, 145 );
      head2ReturnLeft.SetSize( 25, 25 );
      head2ReturnLeft.SetSkin( "Mini Jack 25px" );

      head2ReturnRight = new VoltageAudioJack( "head2ReturnRight", "Head 2 Return Right", this, JackType.JackType_AudioInput );
      AddComponent( head2ReturnRight );
      head2ReturnRight.SetWantsMouseNotifications( false );
      head2ReturnRight.SetPosition( 182, 145 );
      head2ReturnRight.SetSize( 25, 25 );
      head2ReturnRight.SetSkin( "Mini Jack 25px" );

      head5ReturnLeft = new VoltageAudioJack( "head5ReturnLeft", "Head 5 Return Left", this, JackType.JackType_AudioInput );
      AddComponent( head5ReturnLeft );
      head5ReturnLeft.SetWantsMouseNotifications( false );
      head5ReturnLeft.SetPosition( 112, 244 );
      head5ReturnLeft.SetSize( 25, 25 );
      head5ReturnLeft.SetSkin( "Mini Jack 25px" );

      head5ReturnRight = new VoltageAudioJack( "head5ReturnRight", "Head 5 Return Right", this, JackType.JackType_AudioInput );
      AddComponent( head5ReturnRight );
      head5ReturnRight.SetWantsMouseNotifications( false );
      head5ReturnRight.SetPosition( 182, 244 );
      head5ReturnRight.SetSize( 25, 25 );
      head5ReturnRight.SetSkin( "Mini Jack 25px" );

      head6PositionMod = new VoltageAudioJack( "head6PositionMod", "Head 6 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head6PositionMod );
      head6PositionMod.SetWantsMouseNotifications( false );
      head6PositionMod.SetPosition( 41, 277 );
      head6PositionMod.SetSize( 25, 25 );
      head6PositionMod.SetSkin( "Mini Jack 25px" );

      head3PositionMod = new VoltageAudioJack( "head3PositionMod", "Head 3 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head3PositionMod );
      head3PositionMod.SetWantsMouseNotifications( false );
      head3PositionMod.SetPosition( 41, 178 );
      head3PositionMod.SetSize( 25, 25 );
      head3PositionMod.SetSkin( "Mini Jack 25px" );

      head3Position = new VoltageKnob( "head3Position", "Head 3 Position", this, 0.0, 1, 0.50 );
      AddComponent( head3Position );
      head3Position.SetWantsMouseNotifications( false );
      head3Position.SetPosition( 8, 178 );
      head3Position.SetSize( 27, 27 );
      head3Position.SetSkin( "Plastic Blue" );
      head3Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head3Position.SetKnobParams( 215, 145 );
      head3Position.SetUnits( "s" );
      head3Position.DisplayValueInPercent( false );
      head3Position.SetKnobAdjustsRing( true );

      head6Position = new VoltageKnob( "head6Position", "Head 6 Position", this, 0.0, 1, 0.50 );
      AddComponent( head6Position );
      head6Position.SetWantsMouseNotifications( false );
      head6Position.SetPosition( 8, 277 );
      head6Position.SetSize( 27, 27 );
      head6Position.SetSkin( "Plastic Blue" );
      head6Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head6Position.SetKnobParams( 215, 145 );
      head6Position.SetUnits( "s" );
      head6Position.DisplayValueInPercent( false );
      head6Position.SetKnobAdjustsRing( true );

      head6SendLeft = new VoltageAudioJack( "head6SendLeft", "Head 6 Send Left", this, JackType.JackType_AudioOutput );
      AddComponent( head6SendLeft );
      head6SendLeft.SetWantsMouseNotifications( false );
      head6SendLeft.SetPosition( 76, 277 );
      head6SendLeft.SetSize( 25, 25 );
      head6SendLeft.SetSkin( "Mini Jack 25px" );

      head6SendRight = new VoltageAudioJack( "head6SendRight", "Head 6 Send Right", this, JackType.JackType_AudioOutput );
      AddComponent( head6SendRight );
      head6SendRight.SetWantsMouseNotifications( false );
      head6SendRight.SetPosition( 147, 277 );
      head6SendRight.SetSize( 25, 25 );
      head6SendRight.SetSkin( "Mini Jack 25px" );

      head3SendLeft = new VoltageAudioJack( "head3SendLeft", "Head 3 Send Left", this, JackType.JackType_AudioOutput );
      AddComponent( head3SendLeft );
      head3SendLeft.SetWantsMouseNotifications( false );
      head3SendLeft.SetPosition( 76, 178 );
      head3SendLeft.SetSize( 25, 25 );
      head3SendLeft.SetSkin( "Mini Jack 25px" );

      head3SendRight = new VoltageAudioJack( "head3SendRight", "Head 3 Send Right", this, JackType.JackType_AudioOutput );
      AddComponent( head3SendRight );
      head3SendRight.SetWantsMouseNotifications( false );
      head3SendRight.SetPosition( 147, 178 );
      head3SendRight.SetSize( 25, 25 );
      head3SendRight.SetSkin( "Mini Jack 25px" );

      head3ReturnLeft = new VoltageAudioJack( "head3ReturnLeft", "Head 3 Return Left", this, JackType.JackType_AudioInput );
      AddComponent( head3ReturnLeft );
      head3ReturnLeft.SetWantsMouseNotifications( false );
      head3ReturnLeft.SetPosition( 112, 178 );
      head3ReturnLeft.SetSize( 25, 25 );
      head3ReturnLeft.SetSkin( "Mini Jack 25px" );

      head3ReturnRight = new VoltageAudioJack( "head3ReturnRight", "Head 3 Return Right", this, JackType.JackType_AudioInput );
      AddComponent( head3ReturnRight );
      head3ReturnRight.SetWantsMouseNotifications( false );
      head3ReturnRight.SetPosition( 182, 178 );
      head3ReturnRight.SetSize( 25, 25 );
      head3ReturnRight.SetSkin( "Mini Jack 25px" );

      head6ReturnLeft = new VoltageAudioJack( "head6ReturnLeft", "Head 6 Return Left", this, JackType.JackType_AudioInput );
      AddComponent( head6ReturnLeft );
      head6ReturnLeft.SetWantsMouseNotifications( false );
      head6ReturnLeft.SetPosition( 112, 277 );
      head6ReturnLeft.SetSize( 25, 25 );
      head6ReturnLeft.SetSkin( "Mini Jack 25px" );

      head6ReturnRight = new VoltageAudioJack( "head6ReturnRight", "Head 6 Return Right", this, JackType.JackType_AudioInput );
      AddComponent( head6ReturnRight );
      head6ReturnRight.SetWantsMouseNotifications( false );
      head6ReturnRight.SetPosition( 182, 277 );
      head6ReturnRight.SetSize( 25, 25 );
      head6ReturnRight.SetSkin( "Mini Jack 25px" );

      rangeSwitch = new VoltageSwitch( "rangeSwitch", "Range", this, 0 );
      AddComponent( rangeSwitch );
      rangeSwitch.SetWantsMouseNotifications( false );
      rangeSwitch.SetPosition( 90, 310 );
      rangeSwitch.SetSize( 37, 15 );
      rangeSwitch.SetSkin( "5-State Slide Horizontal" );
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
      controller = new StereoController(
         inputJackLeft::GetValue,
         receiver.registerInput(inputJackRight, inputJackRight::GetValue),
         new CvModulatableKnob(
            feedbackKnob.GetMinValue(),
            feedbackKnob.GetMaxValue(),
            receiver.registerInput(feedbackModCv, feedbackModCv::GetValue),
            receiver.registerSmoothedKnob(feedbackKnob, feedbackKnob.GetValue()),
            receiver.registerSmoothedKnob(feedbackModAmount, feedbackModAmount.GetValue())),
         new CvModulatableKnob(
            mixKnob.GetMinValue(),
            mixKnob.GetMaxValue(),
            receiver.registerInput(mixModCv, mixModCv::GetValue),
            receiver.registerSmoothedKnob(mixKnob, mixKnob.GetValue()),
            receiver.registerSmoothedKnob(mixModAmount, mixModAmount.GetValue())),         
         outputJackLeft::SetValue,
         outputJackRight::SetValue,
         new StereoReadHead[] {
            readHead(head1Position, head1PositionMod,
               head1SendLeft, head1SendRight,
               head1ReturnLeft, head1ReturnRight),
            readHead(head2Position, head2PositionMod,
               head2SendLeft, head2SendRight,
               head2ReturnLeft, head2ReturnRight),
            readHead(head3Position, head3PositionMod,
               head3SendLeft, head3SendRight,
               head3ReturnLeft, head3ReturnRight),
            readHead(head4Position, head4PositionMod,
               head4SendLeft, head4SendRight,
               head4ReturnLeft, head4ReturnRight),
            readHead(head5Position, head5PositionMod,
               head5SendLeft, head5SendRight,
               head5ReturnLeft, head5ReturnRight),
            readHead(head6Position, head6PositionMod,
               head6SendLeft, head6SendRight,
               head6ReturnLeft, head6ReturnRight)
         }
      );
      
      receiver.registerTwoStateSwitch(qualitySwitch, controller::setInterpolationQuality);
      receiver.register(rangeSwitch, controller::setRange);


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
         case Knob_Changed: return receiver.knobValueChanged(component, doubleValue);
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed:   // doubleValue is the new button/toggle button value
         {
         }
         break;
      
         case Switch_Changed: return receiver.switchChanged(component, doubleValue);
      
         case Jack_Connected: return receiver.jackConnected(component);
      
         case Jack_Disconnected: return receiver.jackDisconnected(component);
      
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
      controller.processSample();


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
      if (component == head1Position
         || component == head2Position
         || component == head3Position
         || component == head4Position
         || component == head5Position) {
            VoltageKnob knob = (VoltageKnob) component;
            return controller.getPosDescription(knob.GetValue(), rangeSwitch.GetValue());
      }
      
      if (component == rangeSwitch) {
         return controller.getRangeDescription(rangeSwitch.GetValue());
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
   private VoltageSwitch rangeSwitch;
   private VoltageAudioJack head6ReturnRight;
   private VoltageAudioJack head6ReturnLeft;
   private VoltageAudioJack head3ReturnRight;
   private VoltageAudioJack head3ReturnLeft;
   private VoltageAudioJack head3SendRight;
   private VoltageAudioJack head3SendLeft;
   private VoltageAudioJack head6SendRight;
   private VoltageAudioJack head6SendLeft;
   private VoltageKnob head6Position;
   private VoltageKnob head3Position;
   private VoltageAudioJack head3PositionMod;
   private VoltageAudioJack head6PositionMod;
   private VoltageAudioJack head5ReturnRight;
   private VoltageAudioJack head5ReturnLeft;
   private VoltageAudioJack head2ReturnRight;
   private VoltageAudioJack head2ReturnLeft;
   private VoltageAudioJack head5SendRight;
   private VoltageAudioJack head5SendLeft;
   private VoltageAudioJack head2SendRight;
   private VoltageAudioJack head2SendLeft;
   private VoltageKnob head5Position;
   private VoltageKnob head2Position;
   private VoltageAudioJack head5PositionMod;
   private VoltageAudioJack head2PositionMod;
   private VoltageAudioJack head4ReturnRight;
   private VoltageAudioJack head4ReturnLeft;
   private VoltageAudioJack head1ReturnRight;
   private VoltageAudioJack head1ReturnLeft;
   private VoltageAudioJack head4SendRight;
   private VoltageAudioJack head4SendLeft;
   private VoltageAudioJack head1SendRight;
   private VoltageAudioJack head1SendLeft;
   private VoltageKnob head4Position;
   private VoltageKnob head1Position;
   private VoltageAudioJack head4PositionMod;
   private VoltageAudioJack head1PositionMod;
   private VoltageSwitch qualitySwitch;
   private VoltageLabel textLabel10;
   private VoltageLabel textLabel11;
   private VoltageLabel textLabel12;
   private VoltageLabel textLabel9;
   private VoltageLabel textLabel8;
   private VoltageLabel textLabel18;
   private VoltageLabel textLabel17;
   private VoltageLabel textLabel16;
   private VoltageLabel textLabel15;
   private VoltageLabel textLabel14;
   private VoltageLabel textLabel13;
   private VoltageLabel textLabel7;
   private VoltageLabel textLabel6;
   private VoltageLabel textLabel5;
   private VoltageKnob mixModAmount;
   private VoltageKnob feedbackModAmount;
   private VoltageAudioJack mixModCv;
   private VoltageAudioJack feedbackModCv;
   private VoltageKnob mixKnob;
   private VoltageKnob feedbackKnob;
   private VoltageAudioJack outputJackRight;
   private VoltageAudioJack outputJackLeft;
   private VoltageAudioJack inputJackLeft;
   private VoltageAudioJack inputJackRight;
   private VoltageLabel textLabel1;
   private VoltageLabel textLabel19;
   private VoltageLabel textLabel20;
   private VoltageLabel textLabel2;
   private VoltageLabel textLabel3;
   private VoltageLabel textLabel4;


   //[user-code-and-variables]    Add your own variables and functions here
private final NotificationReceiver receiver = new NotificationReceiver();
private StereoController controller;

private StereoReadHead readHead(VoltageKnob headPosition,
   VoltageAudioJack headPositionMod,
   VoltageAudioJack headSendLeft,
   VoltageAudioJack headSendRight,
   VoltageAudioJack headReturnLeft,
   VoltageAudioJack headReturnRight) {
   return new StereoReadHead(
               receiver.registerSmoothedKnob(headPosition, headPosition.GetValue()),
               receiver.registerInput(headPositionMod, headPositionMod::GetValue),
               receiver.registerOutput(headSendLeft, headSendLeft::SetValue),
               receiver.registerOutput(headSendRight, headSendRight::SetValue),
               receiver.registerInput(headReturnLeft, headReturnLeft::GetValue),
               receiver.registerInput(headReturnRight, headReturnRight::GetValue));
}


   //[/user-code-and-variables]
}

 