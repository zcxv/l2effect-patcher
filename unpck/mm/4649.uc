class 4649 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect14
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.bl_poison_cloud_ta'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect15
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.bl_curse_poison_ta'
		bOnMultiTarget=True
	End Object
	Desc="독" //Poison
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect14',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect15',SpecificStage=0)
}