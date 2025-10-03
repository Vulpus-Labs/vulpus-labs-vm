package com.vulpuslabs.cumulonimbus;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.modules.cumulonimbus.*;
import com.vulpuslabs.vulpes.values.events.*;


//[/user-imports]


public class Cumulonimbus extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public Cumulonimbus( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Cumulonimbus", ModuleType.ModuleType_Effect, 3.0 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "790420a3ba46474a8967a86bc964c5f1" );
   }

void InitializeControls()
{

      leftIn = new VoltageAudioJack( "leftIn", "Left In", this, JackType.JackType_AudioInput );
      AddComponent( leftIn );
      leftIn.SetWantsMouseNotifications( false );
      leftIn.SetPosition( 77, 36 );
      leftIn.SetSize( 25, 25 );
      leftIn.SetSkin( "Jack Round Mint Ring" );

      positionModCv = new VoltageAudioJack( "positionModCv", "Position Mod CV", this, JackType.JackType_AudioInput );
      AddComponent( positionModCv );
      positionModCv.SetWantsMouseNotifications( false );
      positionModCv.SetPosition( 5, 260 );
      positionModCv.SetSize( 25, 25 );
      positionModCv.SetSkin( "Jack Round Red Ring" );

      lengthModCv = new VoltageAudioJack( "lengthModCv", "Length Mod CV", this, JackType.JackType_AudioInput );
      AddComponent( lengthModCv );
      lengthModCv.SetWantsMouseNotifications( false );
      lengthModCv.SetPosition( 77, 260 );
      lengthModCv.SetSize( 25, 25 );
      lengthModCv.SetSkin( "Jack Round Cream Ring" );

      feedbackModCv = new VoltageAudioJack( "feedbackModCv", "Feedback Mod CV", this, JackType.JackType_AudioInput );
      AddComponent( feedbackModCv );
      feedbackModCv.SetWantsMouseNotifications( false );
      feedbackModCv.SetPosition( 112, 260 );
      feedbackModCv.SetSize( 25, 25 );
      feedbackModCv.SetSkin( "Jack Round Plum Ring" );

      pitchModCv = new VoltageAudioJack( "pitchModCv", "Pitch Mod CV", this, JackType.JackType_AudioInput );
      AddComponent( pitchModCv );
      pitchModCv.SetWantsMouseNotifications( false );
      pitchModCv.SetPosition( 149, 260 );
      pitchModCv.SetSize( 25, 25 );
      pitchModCv.SetSkin( "Jack Round Mint Ring" );

      fadeModCv = new VoltageAudioJack( "fadeModCv", "Fade Mod CV", this, JackType.JackType_AudioInput );
      AddComponent( fadeModCv );
      fadeModCv.SetWantsMouseNotifications( false );
      fadeModCv.SetPosition( 41, 260 );
      fadeModCv.SetSize( 25, 25 );
      fadeModCv.SetSkin( "Jack Round Yellow Ring" );

      rightIn = new VoltageAudioJack( "rightIn", "Right In", this, JackType.JackType_AudioInput );
      AddComponent( rightIn );
      rightIn.SetWantsMouseNotifications( false );
      rightIn.SetPosition( 112, 36 );
      rightIn.SetSize( 25, 25 );
      rightIn.SetSkin( "Jack Round Sky Ring" );

      freezeGateCv = new VoltageAudioJack( "freezeGateCv", "Freeze Gate CV", this, JackType.JackType_AudioInput );
      AddComponent( freezeGateCv );
      freezeGateCv.SetWantsMouseNotifications( false );
      freezeGateCv.SetPosition( 44, 36 );
      freezeGateCv.SetSize( 25, 25 );
      freezeGateCv.SetSkin( "Jack Round White Ring" );

      leftOut = new VoltageAudioJack( "leftOut", "Left Out", this, JackType.JackType_AudioOutput );
      AddComponent( leftOut );
      leftOut.SetWantsMouseNotifications( false );
      leftOut.SetPosition( 77, 312 );
      leftOut.SetSize( 25, 25 );
      leftOut.SetSkin( "Jack Round Clay Ring" );

      rightOut = new VoltageAudioJack( "rightOut", "Right Out", this, JackType.JackType_AudioOutput );
      AddComponent( rightOut );
      rightOut.SetWantsMouseNotifications( false );
      rightOut.SetPosition( 112, 312 );
      rightOut.SetSize( 25, 25 );
      rightOut.SetSkin( "Jack Round Clay Ring" );

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "FEEDBACK" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 74, 128 );
      textLabel8.SetSize( 67, 16 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel8.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel8.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel8.SetBorderSize( 1 );
      textLabel8.SetMultiLineEdit( false );
      textLabel8.SetIsNumberEditor( false );
      textLabel8.SetNumberEditorRange( 0, 100 );
      textLabel8.SetNumberEditorInterval( 1 );
      textLabel8.SetNumberEditorUsesMouseWheel( false );
      textLabel8.SetHasCustomTextHoverColor( false );
      textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetFont( "Arial", 10, true, false );

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "CUMULONIMBUS" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 0, 0 );
      textLabel1.SetSize( 216, 15 );
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

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "INPUT L/R" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 74, 16 );
      textLabel9.SetSize( 67, 15 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel9.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel9.SetBorderSize( 1 );
      textLabel9.SetMultiLineEdit( false );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "Arial", 10, true, false );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "OUTPUT L/R" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 74, 292 );
      textLabel10.SetSize( 67, 15 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel10.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel10.SetBorderSize( 1 );
      textLabel10.SetMultiLineEdit( false );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "Arial", 10, true, false );

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "POSITION" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 4, 66 );
      textLabel3.SetSize( 67, 15 );
      textLabel3.SetEditable( false, false );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel3.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel3.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel3.SetBorderSize( 1 );
      textLabel3.SetMultiLineEdit( false );
      textLabel3.SetIsNumberEditor( false );
      textLabel3.SetNumberEditorRange( 0, 100 );
      textLabel3.SetNumberEditorInterval( 1 );
      textLabel3.SetNumberEditorUsesMouseWheel( false );
      textLabel3.SetHasCustomTextHoverColor( false );
      textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetFont( "Arial", 10, true, false );

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "LENGTH" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 74, 66 );
      textLabel4.SetSize( 67, 15 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel4.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel4.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel4.SetBorderSize( 1 );
      textLabel4.SetMultiLineEdit( false );
      textLabel4.SetIsNumberEditor( false );
      textLabel4.SetNumberEditorRange( 0, 100 );
      textLabel4.SetNumberEditorInterval( 1 );
      textLabel4.SetNumberEditorUsesMouseWheel( false );
      textLabel4.SetHasCustomTextHoverColor( false );
      textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetFont( "Arial", 10, true, false );

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "PITCH" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 144, 66 );
      textLabel5.SetSize( 67, 15 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel5.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel5.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel5.SetBorderSize( 1 );
      textLabel5.SetMultiLineEdit( false );
      textLabel5.SetIsNumberEditor( false );
      textLabel5.SetNumberEditorRange( 0, 100 );
      textLabel5.SetNumberEditorInterval( 1 );
      textLabel5.SetNumberEditorUsesMouseWheel( false );
      textLabel5.SetHasCustomTextHoverColor( false );
      textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel5.SetFont( "Arial", 10, true, false );

      textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "PAN" );
      AddComponent( textLabel11 );
      textLabel11.SetWantsMouseNotifications( false );
      textLabel11.SetPosition( 144, 128 );
      textLabel11.SetSize( 67, 16 );
      textLabel11.SetEditable( false, false );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel11.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel11.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel11.SetBorderSize( 1 );
      textLabel11.SetMultiLineEdit( false );
      textLabel11.SetIsNumberEditor( false );
      textLabel11.SetNumberEditorRange( 0, 100 );
      textLabel11.SetNumberEditorInterval( 1 );
      textLabel11.SetNumberEditorUsesMouseWheel( false );
      textLabel11.SetHasCustomTextHoverColor( false );
      textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetFont( "Arial", 10, true, false );

      textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "MIX" );
      AddComponent( textLabel14 );
      textLabel14.SetWantsMouseNotifications( false );
      textLabel14.SetPosition( 144, 291 );
      textLabel14.SetSize( 67, 16 );
      textLabel14.SetEditable( false, false );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel14.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel14.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel14.SetBorderSize( 1 );
      textLabel14.SetMultiLineEdit( false );
      textLabel14.SetIsNumberEditor( false );
      textLabel14.SetNumberEditorRange( 0, 100 );
      textLabel14.SetNumberEditorInterval( 1 );
      textLabel14.SetNumberEditorUsesMouseWheel( false );
      textLabel14.SetHasCustomTextHoverColor( false );
      textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel14.SetFont( "Arial", 10, true, false );

      textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "LEVEL" );
      AddComponent( textLabel15 );
      textLabel15.SetWantsMouseNotifications( false );
      textLabel15.SetPosition( 4, 292 );
      textLabel15.SetSize( 67, 16 );
      textLabel15.SetEditable( false, false );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel15.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel15.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel15.SetBorderSize( 1 );
      textLabel15.SetMultiLineEdit( false );
      textLabel15.SetIsNumberEditor( false );
      textLabel15.SetNumberEditorRange( 0, 100 );
      textLabel15.SetNumberEditorInterval( 1 );
      textLabel15.SetNumberEditorUsesMouseWheel( false );
      textLabel15.SetHasCustomTextHoverColor( false );
      textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel15.SetFont( "Arial", 10, true, false );

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "FADE" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 4, 128 );
      textLabel6.SetSize( 67, 16 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel6.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel6.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel6.SetBorderSize( 1 );
      textLabel6.SetMultiLineEdit( false );
      textLabel6.SetIsNumberEditor( false );
      textLabel6.SetNumberEditorRange( 0, 100 );
      textLabel6.SetNumberEditorInterval( 1 );
      textLabel6.SetNumberEditorUsesMouseWheel( false );
      textLabel6.SetHasCustomTextHoverColor( false );
      textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetFont( "Arial", 10, true, false );

      textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "FREEZE GATE" );
      AddComponent( textLabel12 );
      textLabel12.SetWantsMouseNotifications( false );
      textLabel12.SetPosition( 4, 16 );
      textLabel12.SetSize( 67, 15 );
      textLabel12.SetEditable( false, false );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel12.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel12.SetBorderSize( 1 );
      textLabel12.SetMultiLineEdit( false );
      textLabel12.SetIsNumberEditor( false );
      textLabel12.SetNumberEditorRange( 0, 100 );
      textLabel12.SetNumberEditorInterval( 1 );
      textLabel12.SetNumberEditorUsesMouseWheel( false );
      textLabel12.SetHasCustomTextHoverColor( false );
      textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel12.SetFont( "Arial", 10, true, false );

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "VULPUS LABS" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 0, 345 );
      textLabel2.SetSize( 216, 15 );
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
      textLabel2.SetFont( "Arial", 10, true, false );

      lengthKnob = new VoltageKnob( "lengthKnob", "Length", this, 10, 1000, 100 );
      AddComponent( lengthKnob );
      lengthKnob.SetWantsMouseNotifications( false );
      lengthKnob.SetPosition( 89, 88 );
      lengthKnob.SetSize( 35, 35 );
      lengthKnob.SetSkin( "Knurled Plastic Cream" );
      lengthKnob.SetRange( 10, 1000, 100, false, 0 );
      lengthKnob.SetKnobParams( 215, 145 );
      lengthKnob.SetUnits( "ms" );
      lengthKnob.DisplayValueInPercent( false );
      lengthKnob.SetKnobAdjustsRing( true );
      lengthKnob.SetMidpointValue( 200 );

      pitchKnob = new VoltageKnob( "pitchKnob", "Pitch", this, -12, 12, 0 );
      AddComponent( pitchKnob );
      pitchKnob.SetWantsMouseNotifications( false );
      pitchKnob.SetPosition( 159, 88 );
      pitchKnob.SetSize( 35, 35 );
      pitchKnob.SetSkin( "Knurled Plastic Mint" );
      pitchKnob.SetRange( -12, 12, 0, false, 0 );
      pitchKnob.SetKnobParams( 215, 145 );
      pitchKnob.SetUnits( "semitones" );
      pitchKnob.DisplayValueInPercent( false );
      pitchKnob.SetKnobAdjustsRing( true );

      feedbackKnob = new VoltageKnob( "feedbackKnob", "Feedback", this, 0.0, 1.0, 0 );
      AddComponent( feedbackKnob );
      feedbackKnob.SetWantsMouseNotifications( false );
      feedbackKnob.SetPosition( 89, 150 );
      feedbackKnob.SetSize( 35, 35 );
      feedbackKnob.SetSkin( "Knurled Plastic Plum" );
      feedbackKnob.SetRange( 0.0, 1.0, 0, false, 0 );
      feedbackKnob.SetKnobParams( 215, 145 );
      feedbackKnob.DisplayValueInPercent( true );
      feedbackKnob.SetKnobAdjustsRing( true );

      fadeKnob = new VoltageKnob( "fadeKnob", "Fade", this, 0.1, 1, 0.5 );
      AddComponent( fadeKnob );
      fadeKnob.SetWantsMouseNotifications( false );
      fadeKnob.SetPosition( 21, 150 );
      fadeKnob.SetSize( 35, 35 );
      fadeKnob.SetSkin( "Knurled Plastic Yellow" );
      fadeKnob.SetRange( 0.1, 1, 0.5, false, 0 );
      fadeKnob.SetKnobParams( 215, 145 );
      fadeKnob.DisplayValueInPercent( true );
      fadeKnob.SetKnobAdjustsRing( true );
      fadeKnob.SetMidpointValue( 0.5 );

      mixKnob = new VoltageKnob( "mixKnob", "Mix", this, 0.0, 1.0, 0.5 );
      AddComponent( mixKnob );
      mixKnob.SetWantsMouseNotifications( false );
      mixKnob.SetPosition( 164, 312 );
      mixKnob.SetSize( 28, 28 );
      mixKnob.SetSkin( "Cosmo Medium" );
      mixKnob.SetRange( 0.0, 1.0, 0.5, false, 0 );
      mixKnob.SetKnobParams( 215, 145 );
      mixKnob.DisplayValueInPercent( true );
      mixKnob.SetKnobAdjustsRing( true );

      panKnob = new VoltageKnob( "panKnob", "Pan", this, 0, 1.0, 0.5 );
      AddComponent( panKnob );
      panKnob.SetWantsMouseNotifications( false );
      panKnob.SetPosition( 159, 150 );
      panKnob.SetSize( 35, 35 );
      panKnob.SetSkin( "Knurled Plastic Sky" );
      panKnob.SetRange( 0, 1.0, 0.5, false, 0 );
      panKnob.SetKnobParams( 215, 145 );
      panKnob.DisplayValueInPercent( true );
      panKnob.SetKnobAdjustsRing( true );

      levelKnob = new VoltageKnob( "levelKnob", "Level Knob", this, 0.0, 2, 1 );
      AddComponent( levelKnob );
      levelKnob.SetWantsMouseNotifications( false );
      levelKnob.SetPosition( 24, 312 );
      levelKnob.SetSize( 28, 28 );
      levelKnob.SetSkin( "Cosmo Medium" );
      levelKnob.SetRange( 0.0, 2, 1, false, 0 );
      levelKnob.SetKnobParams( 215, 145 );
      levelKnob.DisplayValueInPercent( true );
      levelKnob.SetKnobAdjustsRing( true );

      positionKnob = new VoltageKnob( "positionKnob", "Position", this, 0.0, 1000, 0 );
      AddComponent( positionKnob );
      positionKnob.SetWantsMouseNotifications( false );
      positionKnob.SetPosition( 21, 88 );
      positionKnob.SetSize( 35, 35 );
      positionKnob.SetSkin( "Knurled Plastic Cherry" );
      positionKnob.SetRange( 0.0, 1000, 0, false, 0 );
      positionKnob.SetKnobParams( 215, 145 );
      positionKnob.SetUnits( "ms" );
      positionKnob.DisplayValueInPercent( false );
      positionKnob.SetKnobAdjustsRing( true );

      freezeButton = new VoltageToggle( "freezeButton", "Freeze Button", this, false, 0 );
      AddComponent( freezeButton );
      freezeButton.SetWantsMouseNotifications( false );
      freezeButton.SetPosition( 6, 38 );
      freezeButton.SetSize( 21, 21 );
      freezeButton.SetSkin( "Mini Blue" );
      freezeButton.ShowOverlay( false );
      freezeButton.SetOverlayText( "" );

      freezeLed = new VoltageLED( "freezeLed", "Freeze Indicator", this );
      AddComponent( freezeLed );
      freezeLed.SetWantsMouseNotifications( false );
      freezeLed.SetPosition( 31, 33 );
      freezeLed.SetSize( 11, 11 );
      freezeLed.SetSkin( "Silver Backed Blue" );

      textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "TRIGGER" );
      AddComponent( textLabel13 );
      textLabel13.SetWantsMouseNotifications( false );
      textLabel13.SetPosition( 144, 16 );
      textLabel13.SetSize( 67, 15 );
      textLabel13.SetEditable( false, false );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel13.SetBorderColor( new Color( 255, 255, 255, 32 ) );
      textLabel13.SetBorderSize( 1 );
      textLabel13.SetMultiLineEdit( false );
      textLabel13.SetIsNumberEditor( false );
      textLabel13.SetNumberEditorRange( 0, 100 );
      textLabel13.SetNumberEditorInterval( 1 );
      textLabel13.SetNumberEditorUsesMouseWheel( false );
      textLabel13.SetHasCustomTextHoverColor( false );
      textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel13.SetFont( "Arial", 10, true, false );

      triggerButton = new VoltageButton( "triggerButton", "Trigger Button", this );
      AddComponent( triggerButton );
      triggerButton.SetWantsMouseNotifications( false );
      triggerButton.SetPosition( 146, 38 );
      triggerButton.SetSize( 21, 21 );
      triggerButton.SetSkin( "Large Square" );
      triggerButton.ShowOverlay( false );
      triggerButton.SetOverlayText( "" );
      triggerButton.SetAutoRepeat( false );

      triggerCv = new VoltageAudioJack( "triggerCv", "Trigger CV", this, JackType.JackType_AudioInput );
      AddComponent( triggerCv );
      triggerCv.SetWantsMouseNotifications( false );
      triggerCv.SetPosition( 185, 36 );
      triggerCv.SetSize( 25, 25 );
      triggerCv.SetSkin( "Jack Round White Ring" );

      grainTriggerLed = new VoltageLED( "grainTriggerLed", "Grain Trigger Indicator", this );
      AddComponent( grainTriggerLed );
      grainTriggerLed.SetWantsMouseNotifications( false );
      grainTriggerLed.SetPosition( 171, 33 );
      grainTriggerLed.SetSize( 12, 12 );
      grainTriggerLed.SetSkin( "Red" );

      panModCv = new VoltageAudioJack( "panModCv", "Pan Mod CV", this, JackType.JackType_AudioInput );
      AddComponent( panModCv );
      panModCv.SetWantsMouseNotifications( false );
      panModCv.SetPosition( 185, 260 );
      panModCv.SetSize( 25, 25 );
      panModCv.SetSkin( "Jack Round Sky Ring" );

      positionModAmount = new VoltageKnob( "positionModAmount", "Position Mod Amount", this, -1, 1, 0 );
      AddComponent( positionModAmount );
      positionModAmount.SetWantsMouseNotifications( false );
      positionModAmount.SetPosition( 5, 226 );
      positionModAmount.SetSize( 27, 27 );
      positionModAmount.SetSkin( "Plastic Red" );
      positionModAmount.SetRange( -1, 1, 0, false, 0 );
      positionModAmount.SetKnobParams( 215, 145 );
      positionModAmount.DisplayValueInPercent( true );
      positionModAmount.SetKnobAdjustsRing( true );

      fadeModAmount = new VoltageKnob( "fadeModAmount", "Fade Mod Amount", this, -1, 1, 0 );
      AddComponent( fadeModAmount );
      fadeModAmount.SetWantsMouseNotifications( false );
      fadeModAmount.SetPosition( 41, 226 );
      fadeModAmount.SetSize( 27, 27 );
      fadeModAmount.SetSkin( "Plastic Yellow" );
      fadeModAmount.SetRange( -1, 1, 0, false, 0 );
      fadeModAmount.SetKnobParams( 215, 145 );
      fadeModAmount.DisplayValueInPercent( true );
      fadeModAmount.SetKnobAdjustsRing( true );

      lengthModAmount = new VoltageKnob( "lengthModAmount", "Length Mod Amount", this, -1, 1, 0 );
      AddComponent( lengthModAmount );
      lengthModAmount.SetWantsMouseNotifications( false );
      lengthModAmount.SetPosition( 77, 226 );
      lengthModAmount.SetSize( 27, 27 );
      lengthModAmount.SetSkin( "Plastic Cream" );
      lengthModAmount.SetRange( -1, 1, 0, false, 0 );
      lengthModAmount.SetKnobParams( 215, 145 );
      lengthModAmount.DisplayValueInPercent( true );
      lengthModAmount.SetKnobAdjustsRing( true );

      feedbackModAmount = new VoltageKnob( "feedbackModAmount", "Feedback Mod Amount", this, -1, 1, 0 );
      AddComponent( feedbackModAmount );
      feedbackModAmount.SetWantsMouseNotifications( false );
      feedbackModAmount.SetPosition( 112, 226 );
      feedbackModAmount.SetSize( 27, 27 );
      feedbackModAmount.SetSkin( "Plastic Plum" );
      feedbackModAmount.SetRange( -1, 1, 0, false, 0 );
      feedbackModAmount.SetKnobParams( 215, 145 );
      feedbackModAmount.DisplayValueInPercent( true );
      feedbackModAmount.SetKnobAdjustsRing( true );

      pitchModAmount = new VoltageKnob( "pitchModAmount", "Pitch Mod Amount", this, -1, 1, 0 );
      AddComponent( pitchModAmount );
      pitchModAmount.SetWantsMouseNotifications( false );
      pitchModAmount.SetPosition( 148, 226 );
      pitchModAmount.SetSize( 27, 27 );
      pitchModAmount.SetSkin( "Plastic Mint" );
      pitchModAmount.SetRange( -1, 1, 0, false, 0 );
      pitchModAmount.SetKnobParams( 215, 145 );
      pitchModAmount.DisplayValueInPercent( true );
      pitchModAmount.SetKnobAdjustsRing( true );
      pitchModAmount.SetRangeSkewValue( 0.3, true );

      panModAmount = new VoltageKnob( "panModAmount", "Pan Mod Amount", this, -1, 1, 0 );
      AddComponent( panModAmount );
      panModAmount.SetWantsMouseNotifications( false );
      panModAmount.SetPosition( 184, 226 );
      panModAmount.SetSize( 27, 27 );
      panModAmount.SetSkin( "Plastic Blue" );
      panModAmount.SetRange( -1, 1, 0, false, 0 );
      panModAmount.SetKnobParams( 215, 145 );
      panModAmount.DisplayValueInPercent( true );
      panModAmount.SetKnobAdjustsRing( true );

      bufferContents = new VoltageCanvas( "bufferContents", "Buffer View", this, 204, 32 );
      AddComponent( bufferContents );
      bufferContents.SetWantsMouseNotifications( false );
      bufferContents.SetPosition( 6, 188 );
      bufferContents.SetSize( 204, 32 );
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
      InputBus inputBus = new InputBus(
         connector.leftInput(leftIn),
         connector.rightInput(rightIn),
         connector.freezeGate(freezeButton, freezeGateCv),
         connector.trigger(triggerButton, triggerCv),
         connector.position(positionKnob, positionModAmount, positionModCv),
         connector.length(lengthKnob, lengthModAmount, lengthModCv),
         connector.pitch(pitchKnob, pitchModAmount, pitchModCv),
         connector.fade(fadeKnob, fadeModAmount, fadeModCv),
         connector.feedback(feedbackKnob, feedbackModAmount, feedbackModCv),
         connector.pan(panKnob, panModAmount, panModCv),
         connector.level(levelKnob),
         connector.mix(mixKnob));
      
      OutputBus outputBus = new OutputBus(leftOut::SetValue, rightOut::SetValue);

      controller = new Controller(inputBus, outputBus, 64);

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
         case Knob_Changed: return eventHandler.onKnobValueChanged(component, doubleValue);
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed: return eventHandler.onButtonChanged(component, doubleValue);
      
         case Switch_Changed:   // doubleValue is the new switch value
         {
         }
         break;
      
         case Jack_Connected: return eventHandler.onJackConnected(component);
      
         case Jack_Disconnected: return eventHandler.onJackDisconnected(component);
      
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
            freezeLed.SetValue(controller.isFrozen() ? 1.0 : 0.0);
            grainTriggerLed.SetValue(controller.granuleDensity());
            bufferContents.Invalidate();
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
            controller.drawBuffer(bufferContents.GetGraphics(), bufferContents.GetBitmapWidth(), bufferContents.GetBitmapHeight());
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
   private VoltageCanvas bufferContents;
   private VoltageKnob panModAmount;
   private VoltageKnob pitchModAmount;
   private VoltageKnob feedbackModAmount;
   private VoltageKnob lengthModAmount;
   private VoltageKnob fadeModAmount;
   private VoltageKnob positionModAmount;
   private VoltageAudioJack panModCv;
   private VoltageLED grainTriggerLed;
   private VoltageAudioJack triggerCv;
   private VoltageButton triggerButton;
   private VoltageLabel textLabel13;
   private VoltageLED freezeLed;
   private VoltageToggle freezeButton;
   private VoltageKnob positionKnob;
   private VoltageKnob levelKnob;
   private VoltageKnob panKnob;
   private VoltageKnob mixKnob;
   private VoltageKnob fadeKnob;
   private VoltageKnob feedbackKnob;
   private VoltageKnob pitchKnob;
   private VoltageKnob lengthKnob;
   private VoltageLabel textLabel2;
   private VoltageLabel textLabel12;
   private VoltageLabel textLabel6;
   private VoltageLabel textLabel15;
   private VoltageLabel textLabel14;
   private VoltageLabel textLabel11;
   private VoltageLabel textLabel5;
   private VoltageLabel textLabel4;
   private VoltageLabel textLabel3;
   private VoltageLabel textLabel10;
   private VoltageLabel textLabel9;
   private VoltageLabel textLabel1;
   private VoltageLabel textLabel8;
   private VoltageAudioJack rightOut;
   private VoltageAudioJack leftOut;
   private VoltageAudioJack freezeGateCv;
   private VoltageAudioJack rightIn;
   private VoltageAudioJack fadeModCv;
   private VoltageAudioJack pitchModCv;
   private VoltageAudioJack feedbackModCv;
   private VoltageAudioJack lengthModCv;
   private VoltageAudioJack positionModCv;
   private VoltageAudioJack leftIn;


   //[user-code-and-variables]    Add your own variables and functions here
   private final EventBus eventBus = new EventBus();
   private final UIEventConnector eventConnector = new UIEventConnector(eventBus);
   private final UIEventHandler eventHandler = new UIEventHandler(eventBus);
   private Controller controller;
   private final Connector connector = new Connector(eventConnector);



   //[/user-code-and-variables]
}

 