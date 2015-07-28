class 427 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect31
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-0.850000)
		EffectClass=Class'LineageEffect.s_u806_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect30
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.s_u806_channeling_beam'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect32
		AttachOn=AM_LA
		bUseCharacterRotation=True
		offset=(X=1.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.s_u806_channeling_mesh'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect35
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.s_u806_ta'
	End Object
	Desc="스펠 스탠스" //Spell Stance
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect31',SpecificStage=0)
	ChannelingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect30',SpecificStage=0)
	ChannelingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect32',SpecificStage=0)
	ChannelingActions(2)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect35',SpecificStage=0)
}